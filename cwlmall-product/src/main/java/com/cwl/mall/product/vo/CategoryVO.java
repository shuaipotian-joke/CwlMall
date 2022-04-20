package com.cwl.mall.product.vo;

import com.cwl.mall.product.entity.CategoryEntity;
import lombok.Data;

import java.util.List;

@Data
public class CategoryVO extends CategoryEntity {
    /**
     * 子树
     */
    private List<CategoryVO> chilrenCategory;
}
