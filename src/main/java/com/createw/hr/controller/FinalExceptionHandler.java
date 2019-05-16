package com.createw.hr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createw.hr.domain.base.ResultWrapper;

@RestController
public class FinalExceptionHandler implements ErrorController {
    static final Logger LOGGER = LoggerFactory.getLogger(FinalExceptionHandler.class);
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public ResultWrapper error(HttpServletResponse resp, HttpServletRequest req){
        ResultWrapper baseResponse = new ResultWrapper();
        LOGGER.error("error handler");
        baseResponse.error(resp.getStatus());
        return baseResponse;
    }
}
