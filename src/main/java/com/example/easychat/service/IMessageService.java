package com.example.easychat.service;

import com.example.easychat.data.dto.We3;
import com.example.easychat.data.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.easychat.data.vo.LatestMessage;
import com.example.easychat.data.vo.NewMessage;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wy
 * @since 2024-09-22
 */
public interface IMessageService extends IService<Message> {

    List<LatestMessage> getLatestMessages(Integer receiverId);

    List<NewMessage> getNewMessages(Integer receiverId);

}
