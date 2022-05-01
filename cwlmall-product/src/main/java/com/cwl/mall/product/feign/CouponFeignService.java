package com.cwl.mall.product.feign;

import com.cwl.mall.common.to.SkuReductionTo;
import com.cwl.mall.common.to.SpuBoundTO;
import com.cwl.mall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Spu远程调用
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2022/5/1 14:42
 */
@FeignClient("cwlmall-coupon")
public interface CouponFeignService {
    @PostMapping("coupon/spubounds/save")
    R saveSpuBounds(SpuBoundTO spuBoundTO);

    @PostMapping("coupon/skufullreduction/saveInfo")
    R saveSkuReduction(SkuReductionTo skuReductionTo);
}
