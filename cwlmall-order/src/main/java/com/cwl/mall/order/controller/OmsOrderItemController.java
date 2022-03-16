package com.cwl.mall.order.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cwl.mall.order.entity.OmsOrderItemEntity;
import com.cwl.mall.order.service.OmsOrderItemService;
import com.cwl.mall.common.utils.PageUtils;
import com.cwl.mall.common.utils.R;



/**
 * 订单项信息
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2021-09-23 22:17:02
 */
@RestController
@RequestMapping("order/omsorderitem")
public class OmsOrderItemController {
    @Autowired
    private OmsOrderItemService omsOrderItemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = omsOrderItemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		OmsOrderItemEntity omsOrderItem = omsOrderItemService.getById(id);

        return R.ok().put("omsOrderItem", omsOrderItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody OmsOrderItemEntity omsOrderItem){
		omsOrderItemService.save(omsOrderItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody OmsOrderItemEntity omsOrderItem){
		omsOrderItemService.updateById(omsOrderItem);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		omsOrderItemService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
