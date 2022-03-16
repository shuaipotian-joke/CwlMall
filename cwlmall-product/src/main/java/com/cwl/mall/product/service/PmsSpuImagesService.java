package com.cwl.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cwl.mall.common.utils.PageUtils;
import com.cwl.mall.product.entity.PmsSpuImagesEntity;

import java.util.Map;

/**
 * spu图片
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2021-09-23 21:22:32
 */
public interface PmsSpuImagesService extends IService<PmsSpuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
