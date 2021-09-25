package com.cwl.cwlmall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.cwl.cwlmall.common.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwl.cwlmall.common.utils.PageUtils;

import com.cwl.cwlmall.product.dao.PmsSpuInfoDescDao;
import com.cwl.cwlmall.product.entity.PmsSpuInfoDescEntity;
import com.cwl.cwlmall.product.service.PmsSpuInfoDescService;


@Service("pmsSpuInfoDescService")
public class PmsSpuInfoDescServiceImpl extends ServiceImpl<PmsSpuInfoDescDao, PmsSpuInfoDescEntity> implements PmsSpuInfoDescService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsSpuInfoDescEntity> page = this.page(
                new Query<PmsSpuInfoDescEntity>().getPage(params),
                new QueryWrapper<PmsSpuInfoDescEntity>()
        );

        return new PageUtils(page);
    }

}