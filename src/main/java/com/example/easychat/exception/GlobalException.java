package com.example.easychat.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import com.example.easychat.data.fo.Result;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = NotLoginException.class)
    public Result<String> handle(NotLoginException e, HttpServletRequest request) {
        log.error("SaToken未登录异常 url:{}", request.getRequestURI(), e);
        return Result.error(401, e.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(value = NotPermissionException.class)
    public Result<String> handle(NotPermissionException e, HttpServletRequest request) {
        log.error("SaToken无权限异常 url:{}", request.getRequestURI(), e);
        return Result.error(403, e.getMessage(), request.getRequestURI());
    }

}
