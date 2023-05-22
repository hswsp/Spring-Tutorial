package com.springboot.service;

import com.springboot.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void test() {
        User user = this.userService.findByName("scott");
        Assert.assertEquals("用户名为scott", "scott", user.getUsername());
    }

    @Test
    @Transactional
    public void test2() {
        User user = new User();
        user.setId(this.userService.getSequence("seq_user"));
        user.setUsername("JUnit");
        user.setPasswd("123456");
        user.setStatus("1");
        user.setCreateTime(new Date());
        this.userService.save(user);
    }
}
