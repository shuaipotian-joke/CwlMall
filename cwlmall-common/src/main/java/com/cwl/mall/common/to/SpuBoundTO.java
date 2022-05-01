package com.cwl.mall.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * spu积分传输类
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2022/5/1 14:47
 */
@Data
public class SpuBoundTO {
    private Long spuId;
    private BigDecimal buyBounds;
    private BigDecimal growBounds;
}
