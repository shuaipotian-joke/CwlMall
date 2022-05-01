package com.cwl.mall.product.constants;

import lombok.Getter;

/**
 * 常量
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2022/4/29 20:58
 */
public class ProductConstant {
    @Getter
    public enum AttrEnum{
        ATTR_TYPE_BASE(1,"基本属性"),ATTR_TYPE_SALE(0,"销售属性");

        AttrEnum(int code,String msg){
            this.code = code;
            this.msg = msg;
        }

        private final int code;
        private final String msg;
    }
}
