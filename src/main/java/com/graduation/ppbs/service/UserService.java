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

    public Integer login(String username, String password) throws Exception {
        return userMapper.login(username,password);
    }

    public Integer hasUsername(String username) throws Exception {
        return userMapper.hasUsername(username);
    }

    public void regist(String username, String password, Integer usertype) throws Exception {
        userMapper.regist(username,password,usertype);
    }

    public void updateUser(Integer userid, String username, String name, String password, String telephone,
                           String email) throws Exception {
        userMapper.updateUser(userid,username,name,password,telephone,email);
    }

    public void updateAuditByUserid(Integer userid, Integer audit) throws Exception {
        userMapper.updateAuditByUserid(userid,audit);
    }
}
