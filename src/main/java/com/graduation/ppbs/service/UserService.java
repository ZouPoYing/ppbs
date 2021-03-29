package com.graduation.ppbs.service;

import com.graduation.ppbs.dao.User;
import com.graduation.ppbs.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    public List<User> queryAllUser() throws Exception {
        return userMapper.queryAllUser();
    };

    public User getUserById(Integer userid) throws Exception {
        return userMapper.getUserById(userid);
    };
}
