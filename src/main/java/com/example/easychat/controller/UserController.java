package com.example.easychat.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.example.easychat.data.dto.*;
import com.example.easychat.data.fo.Result;
import com.example.easychat.data.vo.UserInfo;
import com.example.easychat.enums.RelationshipEnum;
import com.example.easychat.service.impl.AssetsServiceImpl;
import com.example.easychat.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
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
    public Result<SaTokenInfo> register(@RequestBody Register register) {
        if (userService.register(register)) {
            StpUtil.login(register.getId());
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            return Result.depends(tokenInfo);
        }
        return Result.error("注册失败");
    }

    @RequestMapping("login")
    public Result<SaTokenInfo> login(@RequestBody Login login) {
        if (userService.login(login)) {
            StpUtil.login(login.getId());
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            return Result.depends(tokenInfo);
        }
        return Result.error("登录失败");
    }

    @RequestMapping("info/{id}")
    public Result<UserInfo> userInfo(@PathVariable String id) {
        return Result.depends(BeanUtil.copyProperties(userService.getById(id), UserInfo.class));
    }

    @RequestMapping("avatar/{id}")
    public ResponseEntity<InputStreamResource> avatar(@PathVariable String id) {
        return assetsService.getAvatarJpg(RelationshipEnum.USER.getCode(), id);
    }

}
