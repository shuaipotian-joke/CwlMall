package com.cwl.mall.product.vo;

import com.cwl.mall.product.entity.CategoryEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
public class CategoryVO extends CategoryEntity {
    /**
     * 子树
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CategoryVO> chilrenCategory;
}
