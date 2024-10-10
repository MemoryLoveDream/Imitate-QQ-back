package com.example.easychat.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.easychat.data.dto.Register;
import com.example.easychat.data.dto.Login;
import com.example.easychat.data.fo.Result;
import com.example.easychat.data.dto.We;
import com.example.easychat.data.vo.SingleInfo;
import com.example.easychat.data.vo.UserInfo;
import com.example.easychat.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("login")
    public Result<Boolean> login(@RequestBody Login login) {
        return Result.depends(userService.login(login));
    }

    @RequestMapping("register")
    public Result<Integer> register(@RequestBody Register register) {
        return Result.depends(userService.register(register));
    }

    @RequestMapping("user_info/{id}")
    public Result<UserInfo> userInfo(@PathVariable Integer id) {
        return Result.depends(BeanUtil.copyProperties(userService.getById(id), UserInfo.class));
    }

    @RequestMapping("single_info")
    public Result<SingleInfo> singleInfo(@RequestBody We we) {
        return Result.depends(userService.getSingleInfo(we));
    }

}
