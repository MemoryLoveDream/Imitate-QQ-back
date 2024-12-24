package com.example.easychat.data.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.*;

/**
 * <p>
 *
 * </p>
 *
 * @author wy
 * @since 2024-09-22
 */
@Data
@AllArgsConstructor
public class SendingMessage implements Serializable {

    @TableField("message_type")
    private Integer messageType;

    @TableField("sender_id")
    private String senderId;

    @TableField("receiver_id")
    private String receiverId;

    @TableField("group_id")
    private String groupId;

    @TableField("send_time")
    @JSONField(format = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime sendTime;

    @TableField("chat_type")
    private Integer chatType;

    private String content;

    public void setSendingMessage() {
        sendTime = LocalDateTime.now();
    }

}
