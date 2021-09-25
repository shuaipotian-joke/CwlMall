package com.cwl.cwlmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cwl.cwlmall.common.utils.PageUtils;
import com.cwl.cwlmall.product.entity.PmsCommentReplayEntity;

import java.util.Map;

/**
 * 商品评价回复关系
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2021-09-23 21:22:32
 */
public interface PmsCommentReplayService extends IService<PmsCommentReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

