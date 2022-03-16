package com.cwl.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cwl.mall.common.utils.PageUtils;
import com.cwl.mall.coupon.entity.SmsHomeSubjectSpuEntity;

import java.util.Map;

/**
 * 专题商品
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2021-09-23 22:32:39
 */
public interface SmsHomeSubjectSpuService extends IService<SmsHomeSubjectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

