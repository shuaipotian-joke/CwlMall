package com.cwl.mall.common;

import lombok.Getter;

/**
 * 全局异常错误码
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2022/4/24 21:03
 */
@Getter
public enum BizCodeEnume {
    UNKNOW_EXCEPTION(10000,"系统未知异常"),
    VALID_EXCEPTION(10001,"参数格式校验失败");

    private final int code;
    private final String msg;
    BizCodeEnume(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
