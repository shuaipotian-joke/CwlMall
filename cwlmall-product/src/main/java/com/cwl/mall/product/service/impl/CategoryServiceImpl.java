package com.cwl.mall.product.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwl.mall.common.utils.PageUtils;
import com.cwl.mall.common.utils.Query;
import com.cwl.mall.product.dao.CategoryDao;
import com.cwl.mall.product.entity.CategoryEntity;
import com.cwl.mall.product.service.CategoryBrandRelationService;
import com.cwl.mall.product.service.CategoryService;
import com.cwl.mall.product.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {
    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 查出所有分类并组装为树形结构
     *
     * @return 树形结构的list
     */
    @Override
    public List<CategoryVO> listTree() {
        // 1.查出所有分类
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        // 2.组装成父子的树形结构
        // 2.1找到一级分类
        List<CategoryVO> level1Category = categoryEntities.stream().filter(e -> e.getParentCid() == 0).map(e -> {
            CategoryVO categoryVO = new CategoryVO();
            BeanUtil.copyProperties(e,categoryVO);
            setChilren(categoryVO, categoryEntities);
            return categoryVO;
        }).sorted(Comparator.comparingInt(CategoryVO::getSort)).collect(Collectors.toList());

        return level1Category;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO 1、检查当前菜单是否被其他地方引用
        if (CollUtil.isNotEmpty(asList)) {
            baseMapper.deleteBatchIds(asList);
        }
    }

    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> paths = new ArrayList<>();
        paths = findParentPath(catelogId,paths);
        Collections.reverse(paths);
        return paths.toArray(new Long[paths.size()]);
    }

    /**
     * 级联更新所有关联的数据
     * @param category
     */
    @Transactional
    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        categoryBrandRelationService.updateCategory(category.getCatId(),category.getName());
    }

    private List<Long> findParentPath(Long catelogId, List<Long> paths) {
        paths.add(catelogId);
        CategoryEntity categoryEntity = this.getById(catelogId);
        if (categoryEntity.getParentCid() != 0) {
            findParentPath(categoryEntity.getParentCid(),paths);
        }
        return paths;
    }

    private void setChilren(CategoryVO currentCategory, List<CategoryEntity> allCategorys) {
        List<CategoryVO> chilren = allCategorys.stream()
            .filter(e -> Objects.equals(e.getParentCid(), currentCategory.getCatId()))
            .map(e -> {
                CategoryVO categoryVO = new CategoryVO();
                BeanUtil.copyProperties(e,categoryVO);
                setChilren(categoryVO, allCategorys);
                return categoryVO;
            })
            .sorted(Comparator.comparingInt(CategoryVO::getSort))
                .collect(Collectors.toList());
        currentCategory.setChilrenCategory(chilren);


    }

}
