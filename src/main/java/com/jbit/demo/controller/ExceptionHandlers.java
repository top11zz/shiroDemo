package com.jbit.demo.controller;
import	java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@ControllerAdvice
public class ExceptionHandlers{
    /**
     * 全局处理Exception
     * 错误的情况下返回500
     * @param ex
     * @param req
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public Map<String,Object> handleOtherExceptions(final Exception ex, final WebRequest req) {
        Map<String, Object> tResult = new HashMap<String, Object>();
        tResult.put("type",ex);
        tResult.put("msg",ex.getMessage());
        return tResult;
    }

}