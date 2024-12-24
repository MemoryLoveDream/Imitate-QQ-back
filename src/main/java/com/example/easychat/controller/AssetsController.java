package com.example.easychat.controller;

import com.example.easychat.data.dto.Id;
import com.example.easychat.data.fo.Result;
import com.example.easychat.enums.RelationshipEnum;
import com.example.easychat.service.impl.AssetsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("assets")
public class AssetsController {

    @Autowired
    private AssetsServiceImpl assetsService;

    @RequestMapping("upload_avatar")
    public boolean uploadAvatar(MultipartFile file, Integer type, String id) {
        return assetsService.saveAvatarJpg(file, type, id);
    }

    @RequestMapping("upload_chat_file")
    public Result<Boolean> chat(MultipartFile file, Integer type, String senderId, String receiverId,
                                String date) {
        return Result.depends(assetsService.saveChatFile(file, type, receiverId, senderId, date));
    }

    @RequestMapping("get_chat_file")
    public ResponseEntity<InputStreamResource> get(Integer type, String senderId, String receiverId, String date) {
        return assetsService.getChatFile(type, receiverId, senderId, date);
    }

    @RequestMapping("mkdir")
    public Result<Boolean> mkdir(@RequestBody Id id) {
        return Result.depends(assetsService.createIdDir(id));
    }

}
