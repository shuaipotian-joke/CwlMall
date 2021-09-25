package com.cwl.cwlmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cwl.cwlmall.common.utils.PageUtils;
import com.cwl.cwlmall.coupon.entity.SmsSkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2021-09-23 22:32:39
 */
public interface SmsSkuFullReductionService extends IService<SmsSkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
