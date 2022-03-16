package com.cwl.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.cwl.mall.common.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwl.mall.common.utils.PageUtils;

import com.cwl.mall.product.dao.PmsSpuImagesDao;
import com.cwl.mall.product.entity.PmsSpuImagesEntity;
import com.cwl.mall.product.service.PmsSpuImagesService;


@Service("pmsSpuImagesService")
public class PmsSpuImagesServiceImpl extends ServiceImpl<PmsSpuImagesDao, PmsSpuImagesEntity> implements PmsSpuImagesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsSpuImagesEntity> page = this.page(
                new Query<PmsSpuImagesEntity>().getPage(params),
                new QueryWrapper<PmsSpuImagesEntity>()
        );

        return new PageUtils(page);
    }

}