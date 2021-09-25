package com.cwl.cwlmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cwl.cwlmall.common.utils.PageUtils;
import com.cwl.cwlmall.coupon.entity.SmsHomeAdvEntity;

import java.util.Map;

/**
 * 首页轮播广告
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2021-09-23 22:32:39
 */
public interface SmsHomeAdvService extends IService<SmsHomeAdvEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

