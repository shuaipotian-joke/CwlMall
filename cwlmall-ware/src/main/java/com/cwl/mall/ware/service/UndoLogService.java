package com.cwl.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cwl.mall.common.utils.PageUtils;
import com.cwl.mall.ware.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2021-09-23 22:27:36
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

