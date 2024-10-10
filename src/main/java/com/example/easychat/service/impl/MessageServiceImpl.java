package com.example.easychat.service.impl;

import com.example.easychat.data.entity.Message;
import com.example.easychat.data.vo.LatestMessage;
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
    public List<LatestMessage> getLatestMessages(Integer receiverId) {
        return messageMapper.getLatestMessages(receiverId);
    }
}
