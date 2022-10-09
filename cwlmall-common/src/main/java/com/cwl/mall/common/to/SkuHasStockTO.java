package com.cwl.mall.common.to;

import lombok.Data;

@Data
public class SkuHasStockTO {
    private Long skuId;
    private Boolean hasStock;
}
