package com.cnhtcqk.userservice.controller;

import com.cnhtcqk.userservice.dto.UserLoginDTO;
import com.cnhtcqk.userservice.entity.User;
import com.cnhtcqk.userservice.service.UserServiceDetail;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by fangzhipeng on 2017/6/1.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceDetail userServiceDetail;

    @PostMapping("/register")
    @ApiOperation(value = "注册用户",notes = "注册用户")
    public User postUser(@RequestParam("username") String username , @RequestParam("password") String password){
        //参数判断，省略
        return userServiceDetail.insertUser(username,password);
    }
    @PostMapping("/login")
    @ApiOperation(value = "登录",notes = "登陆")
    public UserLoginDTO login(@RequestParam("username") String username,@RequestParam("password") String password){
        return userServiceDetail.login(username,password);
    }

}