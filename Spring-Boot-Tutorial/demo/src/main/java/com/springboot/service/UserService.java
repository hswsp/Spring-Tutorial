package com.springboot.service;

import com.springboot.domain.User;

public interface UserService extends IService<User>{
    User findByName(String userName);
    void saveUser(User user);
}
