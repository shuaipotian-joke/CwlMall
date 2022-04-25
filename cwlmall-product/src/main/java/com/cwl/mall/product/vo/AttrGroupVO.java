package com.cwl.mall.product.vo;

import com.cwl.mall.product.entity.AttrGroupEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 属性分组VO
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2022/4/26 7:17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AttrGroupVO extends AttrGroupEntity {
    private Long[] catelogPath;
}
