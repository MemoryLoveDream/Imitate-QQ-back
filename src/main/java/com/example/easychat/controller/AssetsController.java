package com.example.easychat.controller;

import com.example.easychat.data.fo.Result;
import com.example.easychat.service.impl.HdfsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/assets")
public class AssetsController {

    @Autowired
    private HdfsService hdfsService;

    @RequestMapping("/upload" )
    @ResponseBody
    public Result<Boolean> upload(@RequestParam("file") MultipartFile file) {
        hdfsService.uploadFile(file);
        return Result.success();
    }

}
