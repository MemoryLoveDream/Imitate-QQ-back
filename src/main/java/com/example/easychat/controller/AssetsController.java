package com.example.easychat.controller;

import com.example.easychat.data.dto.Id;
import com.example.easychat.data.fo.Result;
import com.example.easychat.service.impl.AssetsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Slf4j
@RestController
@RequestMapping("assets")
public class AssetsController {

    @Autowired
    private AssetsServiceImpl assetsService;

    @RequestMapping("upload" )
    public Result<Boolean> upload(@RequestParam("file") MultipartFile file,
                                  @RequestParam("type") Integer type,
                                  @RequestParam("id") String id) {
        return Result.depends(assetsService.uploadHeadJpg(file, type, id));
    }

    @RequestMapping("mkdir")
    public Result<Boolean> mkdir(@RequestBody Id id) {
        return Result.depends(assetsService.createIdDir(id));
    }

//    @RequestMapping("head")
//    public ResponseEntity<InputStreamResource> head(@RequestBody Id id) {
//        return assetsService.getHeadJpg(id);
//    }

}
