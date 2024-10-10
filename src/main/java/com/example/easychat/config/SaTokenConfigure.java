//package com.example.easychat.config;
//
//import cn.dev33.satoken.interceptor.SaInterceptor;
//import cn.dev33.satoken.router.SaRouter;
//import cn.dev33.satoken.stp.StpUtil;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class SaTokenConfigure implements WebMvcConfigurer {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new SaInterceptor(handle -> {
//            SaRouter.match("/**")
//                    .notMatch("/user/username", "/user/list","/user/login","/user/login1","/test/**")
//                    .check(r -> StpUtil.checkLogin());
//
////            SaRouter.match("/user/**")
////                    .notMatch("/user/username", "/user/list")
////                    .check(r -> StpUtil.checkLogin());
//        })).addPathPatterns("/**");
//    }
//
//}
