package com.example.easychat.mapper;

import com.example.easychat.data.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.easychat.data.vo.LatestMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wy
 * @since 2024-09-22
 */
@Mapper
public interface MessageMapper extends BaseMapper<Message> {

    List<LatestMessage> getLatestMessages(Integer receiverId);

}
