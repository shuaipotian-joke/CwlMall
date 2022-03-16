package com.cwl.mall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cwl.mall.product.entity.PmsSkuInfoEntity;
import com.cwl.mall.product.service.PmsSkuInfoService;
import com.cwl.mall.common.utils.PageUtils;
import com.cwl.mall.common.utils.R;



/**
 * sku信息
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2021-09-23 21:22:32
 */
@RestController
@RequestMapping("product/pmsskuinfo")
public class PmsSkuInfoController {
    @Autowired
    private PmsSkuInfoService pmsSkuInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsSkuInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{skuId}")
    public R info(@PathVariable("skuId") Long skuId){
		PmsSkuInfoEntity pmsSkuInfo = pmsSkuInfoService.getById(skuId);

        return R.ok().put("pmsSkuInfo", pmsSkuInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PmsSkuInfoEntity pmsSkuInfo){
		pmsSkuInfoService.save(pmsSkuInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PmsSkuInfoEntity pmsSkuInfo){
		pmsSkuInfoService.updateById(pmsSkuInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] skuIds){
		pmsSkuInfoService.removeByIds(Arrays.asList(skuIds));

        return R.ok();
    }

}
