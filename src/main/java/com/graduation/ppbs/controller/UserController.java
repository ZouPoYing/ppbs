package com.graduation.ppbs.controller;

import com.graduation.ppbs.dao.User;
import com.graduation.ppbs.service.UserService;
import com.graduation.ppbs.utils.EtityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(originPatterns = "*",allowCredentials ="true")
public class UserController {

    @Autowired(required = false)
    private UserService userService;

    @RequestMapping("/listUser")
    public List<Map<String, Object>> listUser() throws Exception {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        try {
            List<User> users = userService.queryAllUser();
            for (User user : users) {
                result.add(EtityUtils.entityToMap(user));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/getUserById")
    public User getUserById(@RequestBody User user) throws Exception {
        Integer userid = user.getUserid();
        if(userid == null) {
            return null;
        } else {
            return userService.getUserById(userid);
        }
    }

    @RequestMapping("/login")
    public Map<String, Object> login(@RequestBody User user) throws Exception {
        String username = user.getUsername();
        String password = user.getPassword();
        Map<String, Object> result = new HashMap<>();
        if (userService.login(username,password) == null) {
            result.put("msg", "用户名或密码错误");
            return result;
        } else {
            result.put("success", true);
            result.put("userid", userService.login(username,password));
            return result;
        }
    }

    @RequestMapping("/regist")
    public Map<String, Object> regist(@RequestBody User user) throws Exception {
        String username = user.getUsername();
        String password = user.getPassword();
        Integer usertype = user.getUsertype();
        Map<String, Object> result = new HashMap<>();
        if (userService.hasUsername(username).equals(0)) {
            userService.regist(username,password,usertype);
            result.put("success", true);
            return result;
        } else {
            result.put("msg", "用户名已被使用");
            return result;
        }
    }

    @RequestMapping("/updateUser")
    public Map<String, Object> updateUser(@RequestBody User user) throws Exception {
        Integer userid = user.getUserid();
        String username = user.getUsername();
        String name = user.getName();
        String password = user.getPassword();
        String telephone = user.getTelephone();
        String email = user.getEmail();
        Map<String, Object> result = new HashMap<>();
        User user1 = userService.getUserById(userid);
        if (user1.getUsername().equals(username)) {
            userService.updateUser(userid,username,name,password,telephone,email);
            result.put("success", true);
            result.putAll(EtityUtils.entityToMap(userService.getUserById(userid)));
            return result;
        } else if (userService.hasUsername(username).equals(0)) {
            userService.updateUser(userid,username,name,password,telephone,email);
            result.put("success", true);
            result.putAll(EtityUtils.entityToMap(userService.getUserById(userid)));
            return result;
        } else {
            result.put("msg", "用户名已被使用");
            return result;
        }
    }
}
