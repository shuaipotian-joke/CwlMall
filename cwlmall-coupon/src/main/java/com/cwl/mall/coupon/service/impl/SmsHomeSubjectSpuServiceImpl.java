package com.cwl.mall.coupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwl.mall.common.utils.PageUtils;
import com.cwl.mall.common.utils.Query;

import com.cwl.mall.coupon.dao.SmsHomeSubjectSpuDao;
import com.cwl.mall.coupon.entity.SmsHomeSubjectSpuEntity;
import com.cwl.mall.coupon.service.SmsHomeSubjectSpuService;


@Service("smsHomeSubjectSpuService")
public class SmsHomeSubjectSpuServiceImpl extends ServiceImpl<SmsHomeSubjectSpuDao, SmsHomeSubjectSpuEntity> implements SmsHomeSubjectSpuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsHomeSubjectSpuEntity> page = this.page(
                new Query<SmsHomeSubjectSpuEntity>().getPage(params),
                new QueryWrapper<SmsHomeSubjectSpuEntity>()
        );

        return new PageUtils(page);
    }

}