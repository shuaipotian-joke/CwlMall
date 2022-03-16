package com.cwl.mall.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwl.mall.common.utils.PageUtils;
import com.cwl.mall.common.utils.Query;

import com.cwl.mall.member.dao.UmsMemberReceiveAddressDao;
import com.cwl.mall.member.entity.UmsMemberReceiveAddressEntity;
import com.cwl.mall.member.service.UmsMemberReceiveAddressService;


@Service("umsMemberReceiveAddressService")
public class UmsMemberReceiveAddressServiceImpl extends ServiceImpl<UmsMemberReceiveAddressDao, UmsMemberReceiveAddressEntity> implements UmsMemberReceiveAddressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsMemberReceiveAddressEntity> page = this.page(
                new Query<UmsMemberReceiveAddressEntity>().getPage(params),
                new QueryWrapper<UmsMemberReceiveAddressEntity>()
        );

        return new PageUtils(page);
    }

}