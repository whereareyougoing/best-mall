package com.imooc.mall.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 宋艾衡
 * 2019/7/16 10:39
 */

@Slf4j
@Component
public class ExceptionResolver implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        log.error("{} exception",request.getRequestURI(),ex);
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        mv.addObject("status", ResponseCode.ERROR.getCode());
        mv.addObject("msg", "接口异常，具体异常信息请查询日志");
        mv.addObject("data", ex.toString());
        return mv;
    }
}
