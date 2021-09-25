package com.cwl.cwlmall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.cwl.cwlmall.common.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwl.cwlmall.common.utils.PageUtils;

import com.cwl.cwlmall.product.dao.PmsSkuSaleAttrValueDao;
import com.cwl.cwlmall.product.entity.PmsSkuSaleAttrValueEntity;
import com.cwl.cwlmall.product.service.PmsSkuSaleAttrValueService;


@Service("pmsSkuSaleAttrValueService")
public class PmsSkuSaleAttrValueServiceImpl extends ServiceImpl<PmsSkuSaleAttrValueDao, PmsSkuSaleAttrValueEntity> implements PmsSkuSaleAttrValueService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsSkuSaleAttrValueEntity> page = this.page(
                new Query<PmsSkuSaleAttrValueEntity>().getPage(params),
                new QueryWrapper<PmsSkuSaleAttrValueEntity>()
        );

        return new PageUtils(page);
    }

}