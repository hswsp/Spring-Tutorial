package com.example.server.controller;

import com.example.server.config.BlogProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RootIndexController {
    @Autowired
    private BlogProperties blogProperties;

    @RequestMapping("/hello")
    public String rootIndex() {
        return blogProperties.getName()+"——"+blogProperties.getTitle();
    }
}
