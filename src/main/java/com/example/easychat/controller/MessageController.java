package com.example.easychat.controller;

import com.example.easychat.data.fo.Result;
import com.example.easychat.data.vo.NewMessage;
import com.example.easychat.service.impl.MessageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wy
 * @since 2024-08-03
 */
@Slf4j
@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    private MessageServiceImpl messageService;

    @RequestMapping("new/{receiverId}")
    public Result<List<NewMessage>> newMessage(@PathVariable String receiverId) {
        return Result.depends(messageService.getNewMessages(receiverId));
    }

//    @RequestMapping("upload_chat")
//    public Result<Boolean> chat(MultipartFile file, Integer type, String senderId, String receiverId,
//                                String date) {
//        return Result.depends(assetsService.saveChatFile(file, type, receiverId, senderId, date));
//    }

}
