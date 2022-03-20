package com.cwl.mall.order.dao;

import com.cwl.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2022-03-20 16:29:01
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
