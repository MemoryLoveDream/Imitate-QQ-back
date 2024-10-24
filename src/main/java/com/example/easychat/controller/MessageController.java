package com.example.easychat.controller;

import com.example.easychat.data.dto.We3;
import com.example.easychat.data.fo.Result;
import com.example.easychat.data.vo.LatestMessage;
import com.example.easychat.data.vo.NewMessage;
import com.example.easychat.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wy
 * @since 2024-08-03
 */
@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    private MessageServiceImpl messageService;

    @RequestMapping("new_messages/{receiverId}")
    public Result<List<NewMessage>> newMessage(@PathVariable Integer receiverId) {
        return Result.depends(messageService.getNewMessages(receiverId));
    }

    @RequestMapping("latest_messages/{id}")
    public Result<List<LatestMessage>> latestMessages(@PathVariable Integer id) {
        return Result.depends(messageService.getLatestMessages(id));
    }

}
