package com.example.library.config.exception;

import com.example.library.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author RuKunHe(jom4ker @ aliyun.com)
 * @version com.wgzmb.framework.common.exception 0.0.1
 */
@Slf4j
@RestControllerAdvice
public class ServerExceptionHandler {
    /**
     * 处理自定义异常
     */
    @ExceptionHandler(ServerException.class)
    public R handleException(ServerException ex) {
        return R.error(ex.getCode(), ex.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public R handleException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return R.error();
    }
}
