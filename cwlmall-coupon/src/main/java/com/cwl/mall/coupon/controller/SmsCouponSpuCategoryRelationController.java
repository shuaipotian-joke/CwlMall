package com.cwl.mall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cwl.mall.coupon.entity.SmsCouponSpuCategoryRelationEntity;
import com.cwl.mall.coupon.service.SmsCouponSpuCategoryRelationService;
import com.cwl.mall.common.utils.PageUtils;
import com.cwl.mall.common.utils.R;



/**
 * 优惠券分类关联
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2021-09-23 22:32:39
 */
@RestController
@RequestMapping("coupon/smscouponspucategoryrelation")
public class SmsCouponSpuCategoryRelationController {
    @Autowired
    private SmsCouponSpuCategoryRelationService smsCouponSpuCategoryRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsCouponSpuCategoryRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SmsCouponSpuCategoryRelationEntity smsCouponSpuCategoryRelation = smsCouponSpuCategoryRelationService.getById(id);

        return R.ok().put("smsCouponSpuCategoryRelation", smsCouponSpuCategoryRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SmsCouponSpuCategoryRelationEntity smsCouponSpuCategoryRelation){
		smsCouponSpuCategoryRelationService.save(smsCouponSpuCategoryRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SmsCouponSpuCategoryRelationEntity smsCouponSpuCategoryRelation){
		smsCouponSpuCategoryRelationService.updateById(smsCouponSpuCategoryRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		smsCouponSpuCategoryRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}