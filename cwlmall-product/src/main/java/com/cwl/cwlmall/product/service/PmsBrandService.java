package com.cwl.cwlmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cwl.cwlmall.common.utils.PageUtils;
import com.cwl.cwlmall.product.entity.PmsBrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2021-09-23 21:22:32
 */
public interface PmsBrandService extends IService<PmsBrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
