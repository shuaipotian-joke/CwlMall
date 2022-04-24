package com.cwl.mall.product.exception;

import com.cwl.mall.common.BizCodeEnume;
import com.cwl.mall.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常
 *
 * @author cwl
 * @email 1045501964@qq.com
 * @date 2022/4/24 20:56
 */
@Slf4j
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e){
        log.error("数据校验异常");
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> map = new HashMap<>();
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(item->{
                String message = item.getDefaultMessage();
                String field = item.getField();
                map.put(field,message);
            });
        }
        return R.error(BizCodeEnume.VALID_EXCEPTION.getCode(),BizCodeEnume.VALID_EXCEPTION.getMsg()).put("data",map);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleValidException(Throwable e){
        log.error("系统异常：",e);
        return R.error(BizCodeEnume.UNKNOW_EXCEPTION.getCode(),BizCodeEnume.UNKNOW_EXCEPTION.getMsg());
    }
}
