package com.cwl.mall.coupon.dao;

import com.cwl.mall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2022-03-20 16:24:50
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
