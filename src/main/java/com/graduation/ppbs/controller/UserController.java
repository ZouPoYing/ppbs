package com.graduation.ppbs.controller;

import com.graduation.ppbs.dao.User;
import com.graduation.ppbs.service.UserService;
import com.graduation.ppbs.utils.EtityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
}
