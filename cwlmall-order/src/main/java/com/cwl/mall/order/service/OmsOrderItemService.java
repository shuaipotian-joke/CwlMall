package com.cwl.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cwl.mall.common.utils.PageUtils;
import com.cwl.mall.order.entity.OmsOrderItemEntity;

import java.util.Map;

/**
 * 订单项信息
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2021-09-23 22:17:02
 */
public interface OmsOrderItemService extends IService<OmsOrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

