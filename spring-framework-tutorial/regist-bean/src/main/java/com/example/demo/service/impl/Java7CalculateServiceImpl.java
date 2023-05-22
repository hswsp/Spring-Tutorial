package com.example.demo.service.impl;

import com.example.demo.service.CalculateService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author MrBird
 */
@Service
@Profile("java7")
public class Java7CalculateServiceImpl implements CalculateService {

    @Override
    public Integer sum(Integer... value) {
        System.out.println("Java 7环境下执行");
        int result = 0;
        for (int i = 0; i <= value.length; i++) {
            result += i;
        }
        return result;
    }
}
