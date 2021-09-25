package com.cwl.cwlmall.coupon.dao;

import com.cwl.cwlmall.coupon.entity.SmsHomeSubjectEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 * 
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2021-09-23 22:32:39
 */
@Mapper
public interface SmsHomeSubjectDao extends BaseMapper<SmsHomeSubjectEntity> {
	
}
