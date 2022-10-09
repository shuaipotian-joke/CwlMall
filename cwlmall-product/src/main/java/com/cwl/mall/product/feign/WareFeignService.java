package com.cwl.mall.product.feign;


import com.cwl.mall.common.to.SkuHasStockTO;
import com.cwl.mall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("cwlmall-ware")
public interface WareFeignService {

    /**
     * 查询sku是否有库存
     */
    @PostMapping("/ware/waresku/hasstock")
    R<List<SkuHasStockTO>> getSkusHasStock(@RequestBody List<Long> skuIds);
}
