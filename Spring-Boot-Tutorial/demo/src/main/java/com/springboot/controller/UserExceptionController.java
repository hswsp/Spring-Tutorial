package com.springboot.controller;

import com.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userexception")
public class UserExceptionController {
    @GetMapping("/{id:\\d+}")
    public void get(@PathVariable String id) {
        throw new UserNotExistException(id);
//        throw new RuntimeException("user not exist");
    }
}
