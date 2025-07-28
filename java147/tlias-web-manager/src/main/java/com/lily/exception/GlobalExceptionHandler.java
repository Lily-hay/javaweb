/*package com.lily.exception;

import com.lily.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
//@ControllerAdvice
//@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result doException(Exception ex)
    {
        log.error(ex.getMessage());
        return Result.error("出错了，请联系管理员！");
    }
}*/
