package com.cwl.mall.product;

import lombok.Data;

import java.util.List;

@Data
public class CategoryVO {
    private Long catId;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 父分类id
     */
    private Long parentCid;
    /**
     * 层级
     */
    private Integer catLevel;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 子树
     */
    private List<CategoryVO> chilrenCategory;
}
