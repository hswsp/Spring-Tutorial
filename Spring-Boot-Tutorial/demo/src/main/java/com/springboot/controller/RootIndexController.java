package com.springboot.controller;

import com.springboot.config.BlogProperties;
import com.springboot.config.ConfigBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RootIndexController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BlogProperties blogProperties;
    @Autowired
    private ConfigBean configBean;

    @RequestMapping("/description")
    public String rootIndex() {
        //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");
//        return blogProperties.getName()+"——"+blogProperties.getTitle();
        return configBean.getName()+"——"+configBean.getTitle();
//          return "hello spring boot";

    }
}
