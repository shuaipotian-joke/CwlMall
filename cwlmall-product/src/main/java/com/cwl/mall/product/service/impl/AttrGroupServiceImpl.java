package com.cwl.mall.product.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwl.mall.common.utils.PageUtils;
import com.cwl.mall.common.utils.Query;
import com.cwl.mall.product.dao.AttrGroupDao;
import com.cwl.mall.product.entity.AttrAttrgroupRelationEntity;
import com.cwl.mall.product.entity.AttrEntity;
import com.cwl.mall.product.entity.AttrGroupEntity;
import com.cwl.mall.product.service.AttrAttrgroupRelationService;
import com.cwl.mall.product.service.AttrGroupService;
import com.cwl.mall.product.service.AttrService;
import com.cwl.mall.product.vo.AttrGroupVO;
import com.cwl.mall.product.vo.AttrGroupWithAttrsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {
    @Autowired
    private AttrGroupDao attrGroupDao;
    @Autowired
    private AttrService attrService;
    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catalogId) {
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<>();
        String key = (String) params.get("key");
        if (catalogId != 0) {
            wrapper.eq("catelog_id",catalogId);
        }
        if (StrUtil.isNotEmpty(key)) {
            wrapper.and((obj)->{
                obj.eq("attr_group_id",key).or().like("attr_group_name",key);
            });
        }
        IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params), wrapper);
        return new PageUtils(page);

    }

    @Override
    public AttrGroupVO getVOById(Long attrGroupId) {
        return attrGroupDao.selectOneVO(attrGroupId);
    }

    /**
     * 根据分类id查出所有的分组一集这些组里面的属性
     *
     * @param catelogId 分类id
     * @return 属性及属性分组信息
     */
    @Override
    public List<AttrGroupWithAttrsVo> getAttrGroupWithAttrsByCatelogId(Long catelogId) {
        // 查询对应分组
        List<AttrGroupEntity> attrGroupEntityList = list(new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId));
        if (CollUtil.isEmpty(attrGroupEntityList)){
            return null;
        }
        // 筛出分组id
        List<Long> attrGroupIdList = attrGroupEntityList.stream().map(AttrGroupEntity::getAttrGroupId).collect(Collectors.toList());

        // 根据分组id查询属性与分组关联信息
        List<AttrAttrgroupRelationEntity> attrAttrgroupRelationEntityList = attrAttrgroupRelationService.list(new QueryWrapper<AttrAttrgroupRelationEntity>().in("attr_group_id", attrGroupIdList));
        // 筛除属性id
        List<Long> attrIdList = attrAttrgroupRelationEntityList.stream().map(AttrAttrgroupRelationEntity::getAttrId).collect(Collectors.toList());
        // 查询属性详情
        List<AttrEntity> attrEntityList = attrService.listByIds(attrIdList);
        // 组装返回的vo列表
        List<AttrGroupWithAttrsVo> attrGroupWithAttrsVoList = attrGroupEntityList.stream().map(attrGroupEntity -> {
            AttrGroupWithAttrsVo attrGroupWithAttrsVo = new AttrGroupWithAttrsVo();
            // 每个vo与每个属性分组一一对应
            BeanUtils.copyProperties(attrGroupEntity, attrGroupWithAttrsVo);
            // 根据关联表对应关系，把关联信息中在当前遍历的属性分组关联的属性筛选出来
            List<Long> filterAttrIdList  = attrAttrgroupRelationEntityList.stream()
                    .filter(attrAttrgroupRelationEntity -> Objects.equals(attrAttrgroupRelationEntity.getAttrGroupId(), attrGroupEntity.getAttrGroupId()))
                    .map(AttrAttrgroupRelationEntity::getAttrId)
                    .collect(Collectors.toList());
            List<AttrEntity> attrEntities = attrEntityList.stream().filter(attrEntity -> filterAttrIdList.contains(attrEntity.getAttrId())).collect(Collectors.toList());
            attrGroupWithAttrsVo.setAttrs(attrEntities);
            return attrGroupWithAttrsVo;
        }).filter(attrGroupWithAttrsVo-> CollUtil.isNotEmpty(attrGroupWithAttrsVo.getAttrs())).collect(Collectors.toList());
        return attrGroupWithAttrsVoList;
    }

}
