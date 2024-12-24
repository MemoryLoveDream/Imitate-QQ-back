package com.example.easychat.controller;

import com.example.easychat.annotation.MappingController;
import org.springframework.web.bind.annotation.RequestMapping;

@MappingController("/test")
public class TestController {

    @RequestMapping("hello")
    public String test() {
        return "Hello World!";
    }

}
