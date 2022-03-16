package com.cwl.mall.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwl.mall.common.utils.PageUtils;
import com.cwl.mall.common.utils.Query;

import com.cwl.mall.order.dao.OmsOrderSettingDao;
import com.cwl.mall.order.entity.OmsOrderSettingEntity;
import com.cwl.mall.order.service.OmsOrderSettingService;


@Service("omsOrderSettingService")
public class OmsOrderSettingServiceImpl extends ServiceImpl<OmsOrderSettingDao, OmsOrderSettingEntity> implements OmsOrderSettingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OmsOrderSettingEntity> page = this.page(
                new Query<OmsOrderSettingEntity>().getPage(params),
                new QueryWrapper<OmsOrderSettingEntity>()
        );

        return new PageUtils(page);
    }

}