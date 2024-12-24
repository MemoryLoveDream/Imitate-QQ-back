package com.example.easychat.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.easychat.data.dto.*;
import com.example.easychat.data.fo.Result;
import com.example.easychat.data.vo.PersonalInfo;
import com.example.easychat.data.vo.UserInfo;
import com.example.easychat.enums.RelationshipEnum;
import com.example.easychat.service.impl.AssetsServiceImpl;
import com.example.easychat.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AssetsServiceImpl assetsService;

    @RequestMapping("verify")
    public Result<Integer> verify(@RequestBody Verification verification) {
        return Result.depends(userService.verify(verification));
    }

    @RequestMapping("register")
    public Result<Integer> register(@RequestBody Register register) {
        return Result.depends(userService.register(register));
    }

    @RequestMapping("login")
    public Result<Boolean> login(@RequestBody Login login) {
        return Result.depends(userService.login(login));
    }

    @RequestMapping("user_info/{id}")
    public Result<UserInfo> userInfo(@PathVariable String id) {
        return Result.depends(BeanUtil.copyProperties(userService.getById(id), UserInfo.class));
    }

    @RequestMapping("personal_info")
    public Result<PersonalInfo> personalInfo(@RequestBody We we) {
        return Result.depends(userService.getPersonalInfo(we));
    }

    @RequestMapping("avatar/{id}")
    public ResponseEntity<InputStreamResource> head(@PathVariable String id) {
        return assetsService.getAvatarJpg(RelationshipEnum.USER.getCode(), id);
    }

}
