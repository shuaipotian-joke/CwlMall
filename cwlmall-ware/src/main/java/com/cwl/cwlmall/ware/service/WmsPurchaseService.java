package com.cwl.cwlmall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cwl.cwlmall.common.utils.PageUtils;
import com.cwl.cwlmall.ware.entity.WmsPurchaseEntity;

import java.util.Map;

/**
 * 采购信息
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2021-09-23 22:27:36
 */
public interface WmsPurchaseService extends IService<WmsPurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

