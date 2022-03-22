package com.cwl.mall.product;

import com.cwl.mall.product.entity.CategoryEntity;
import lombok.Data;

import java.util.List;

@Data
public class CategoryVO {
    private CategoryEntity categoryEntity;
    private List<CategoryVO> chilrenCategory;
}
