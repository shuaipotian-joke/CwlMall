package com.cwl.mall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cwl.mall.coupon.entity.SmsSeckillPromotionEntity;
import com.cwl.mall.coupon.service.SmsSeckillPromotionService;
import com.cwl.mall.common.utils.PageUtils;
import com.cwl.mall.common.utils.R;



/**
 * 秒杀活动
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2021-09-23 22:32:39
 */
@RestController
@RequestMapping("coupon/smsseckillpromotion")
public class SmsSeckillPromotionController {
    @Autowired
    private SmsSeckillPromotionService smsSeckillPromotionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsSeckillPromotionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SmsSeckillPromotionEntity smsSeckillPromotion = smsSeckillPromotionService.getById(id);

        return R.ok().put("smsSeckillPromotion", smsSeckillPromotion);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SmsSeckillPromotionEntity smsSeckillPromotion){
		smsSeckillPromotionService.save(smsSeckillPromotion);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SmsSeckillPromotionEntity smsSeckillPromotion){
		smsSeckillPromotionService.updateById(smsSeckillPromotion);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		smsSeckillPromotionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
