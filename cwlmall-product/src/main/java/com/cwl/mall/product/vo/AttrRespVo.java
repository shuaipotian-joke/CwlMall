package com.cwl.mall.product.vo;

import lombok.Data;

@Data
public class AttrRespVo extends AttrVo {
    /**
     * 			"catelogName": "手机/数码/手机", //所属分类名字
     * 			"groupName": "主体", //所属分组名字
     */
    private String catelogName;

    private String groupName;

    private Long[] catelogPath;
    /**
     * 值类型[0-为单个值，1-可以选择多个值]
     */
    private Integer valueType;
}
