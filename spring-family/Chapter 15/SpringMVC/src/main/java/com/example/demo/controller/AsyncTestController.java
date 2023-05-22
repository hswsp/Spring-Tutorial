package com.example.demo.controller;

import com.example.demo.service.AsyncTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
public class AsyncTestController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AsyncTestService testService;

    @GetMapping("async")
    public void testAsync() {
        long start = System.currentTimeMillis();
        logger.info("异步方法开始");

        testService.asyncMethod();

        logger.info("异步方法结束");
        long end = System.currentTimeMillis();
        logger.info("总耗时：{} ms", end - start);
    }

    @GetMapping("sync")
    public void testSync() {
        long start = System.currentTimeMillis();
        logger.info("同步方法开始");

        testService.syncMethod();

        logger.info("同步方法结束");
        long end = System.currentTimeMillis();
        logger.info("总耗时：{} ms", end - start);
    }

    @GetMapping("asynccall")
    public String testAsyncCallBack() throws Exception {
        long start = System.currentTimeMillis();
        logger.info("异步方法开始");

        Future<String> stringFuture = testService.asyncCallBackMethod();
        String result = stringFuture.get();
        logger.info("异步方法返回值：{}", result);

        logger.info("异步方法结束");

        long end = System.currentTimeMillis();
        logger.info("总耗时：{} ms", end - start);
        return stringFuture.get();
    }

}
