package com.example.easychat.service.impl;

import com.example.easychat.data.dto.SendingMessage;
import com.example.easychat.data.dto.We;
import com.example.easychat.data.entity.Message;
import com.example.easychat.data.vo.NewMessage;
import com.example.easychat.mapper.MessageMapper;
import com.example.easychat.service.IMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wy
 * @since 2024-09-22
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<NewMessage> getNewMessages(String receiverId) {
        List<NewMessage> newMessages =messageMapper.getNewMessages(receiverId);
        if(newMessages != null) {
            for(NewMessage newMessage: newMessages) {
                if (newMessage.getMessageType() == 1)
                    newMessage.setChats(messageMapper.getPersonChats(new We(receiverId ,newMessage.getId())));
                else newMessage.setChats(messageMapper.getGroupChats(new We(receiverId, newMessage.getId())));
            }
        }
        return newMessages;
    }

    public void addMessage(SendingMessage message) {
        //messageMapper.insert(message);
    }

}
