package com.springboot.service.impl;

import com.springboot.dao.mysql.MySQLSeqenceMapper;
import com.springboot.domain.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Repository("userService")
public class MySQLUserServiceImpl extends BaseService<User> implements UserService {
    @Autowired
    public void setSeqenceMapper(MySQLSeqenceMapper seqenceMapper) {
        this.seqenceMapper = seqenceMapper;
    }

    @Override
    public User findByName(String userName) {
        Example example = new Example(User.class);
        example.createCriteria().andCondition("username=", userName);
        List<User> userList = this.selectByExample(example);
        if (userList.size() != 0)
            return userList.get(0);
        else
            return null;
    }

    @Override
    public void saveUser(User user) {
        user.setId(this.getSequence("seq_user"));
        user.setCreateTime(new Date());
        this.save(user);
    }

}


