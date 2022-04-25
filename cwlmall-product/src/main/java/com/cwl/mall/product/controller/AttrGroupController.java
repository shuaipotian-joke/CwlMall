package com.cwl.mall.product.controller;

import cn.hutool.core.bean.BeanUtil;
import com.cwl.mall.common.utils.PageUtils;
import com.cwl.mall.common.utils.R;
import com.cwl.mall.product.entity.AttrGroupEntity;
import com.cwl.mall.product.service.AttrGroupService;
import com.cwl.mall.product.service.CategoryService;
import com.cwl.mall.product.vo.AttrGroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 属性分组
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2022-03-20 16:22:19
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list/{catalogId}")
    public R list(@RequestParam Map<String, Object> params,@PathVariable("catalogId")Long catalogId){
        PageUtils page = attrGroupService.queryPage(params, catalogId);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        Long catelogId = attrGroup.getCatelogId();
        Long[] path = categoryService.findCatelogPath(catelogId);
        AttrGroupVO attrGroupVO = new AttrGroupVO();
        attrGroupVO.setCatelogPath(path);
        BeanUtil.copyProperties(attrGroup,attrGroupVO);

        return R.ok().put("attrGroup", attrGroupVO);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

}
