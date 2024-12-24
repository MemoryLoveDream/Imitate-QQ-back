package com.example.easychat.data.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LatestMessage implements Serializable {

    @TableField("sender_id")
    private Integer senderId;
    @TableField("group_id")
    private Integer groupId;
    private String nickname;
    @TableField("send_time")
    private LocalDateTime sendTime;
    @TableField("message_type")
    private Integer messageType;
    @TableField("chat_type")
    private Integer chatType;
    private String content;
    private Integer unread;

}
