package com.cwl.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cwl.mall.common.utils.PageUtils;
import com.cwl.mall.member.entity.UmsMemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2021-09-23 22:30:06
 */
public interface UmsMemberService extends IService<UmsMemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

