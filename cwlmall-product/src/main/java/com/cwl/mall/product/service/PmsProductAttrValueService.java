package com.cwl.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cwl.mall.common.utils.PageUtils;
import com.cwl.mall.product.entity.PmsProductAttrValueEntity;

import java.util.Map;

/**
 * spu属性值
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2021-09-23 21:22:32
 */
public interface PmsProductAttrValueService extends IService<PmsProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

