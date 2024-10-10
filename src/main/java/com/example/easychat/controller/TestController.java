package com.example.easychat.controller;

import cn.hutool.core.util.StrUtil;
import com.example.easychat.annotation.MappingController;
import com.example.easychat.service.RedisService;
import com.example.easychat.utils.NonStaticResourceHttpRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;


@MappingController("/test")
public class TestController {

    @Autowired
    private NonStaticResourceHttpRequestHandler nonStaticResourceHttpRequestHandler;

    @Autowired
    private RedisService redisService;

    @RequestMapping("hello")
    public String test() {
        return "Hello World!";
    }

    @RequestMapping("video")
    public void getPlayResource(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Path path = Paths.get("E:\\铭冥\\2023\\冬日散步.mp4");
        if (Files.exists(path)) {
            String mimeType = Files.probeContentType(path);
            if (!StrUtil.isEmpty(mimeType)) {
                response.setContentType(mimeType);
            }
            request.setAttribute(NonStaticResourceHttpRequestHandler.ATTR_FILE, path);
            nonStaticResourceHttpRequestHandler.handleRequest(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        }
    }

    @RequestMapping("redis")
    public Object redis() {
        redisService.setValue("k1", "hello redis");
        Set<Integer> rows1 = new HashSet<>();

        return redisService.getValue("k1");
    }



}
