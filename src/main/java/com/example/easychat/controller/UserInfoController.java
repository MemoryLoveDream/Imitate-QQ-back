//package com.example.easychat.controller;
//
//import cn.dev33.satoken.stp.SaTokenInfo;
//import cn.dev33.satoken.stp.StpUtil;
//import com.example.easychat.annotation.MappingController;
//import com.example.easychat.fo.dto.Login;
//import com.example.easychat.fo.Result;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Slf4j
//@MappingController("user")
//public class UserInfoController {
//
//    @Autowired
//    private UserServiceImpl userService;
//
//    @RequestMapping("login")
//    public Result<Map<String, String>> login(@RequestBody Login login) {
//        if ("1".equals(login.getUsername()) && "1".equals(login.getPassword())) {
//            StpUtil.login("1");
////            String salt = RandomUtil.randomString(16);
//            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
//            Map<String, String> map = new HashMap<>(2);
//            map.put("tokenHead", tokenInfo.tokenName);
//            map.put("token", tokenInfo.tokenValue);
//            return Result.success(map);
//        }
//        return Result.error("账号密码错误");
//    }
//
//    @RequestMapping("list")
//    public List<User> findAll() {
//        return userService.list();
//    }
//
//    @RequestMapping("login1")
//    public Result<String> lll() {
//        return Result.success("登录成功");
//    }
//
//}
