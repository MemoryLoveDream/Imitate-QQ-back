package com.example.easychat.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wy
 * @since 2024-09-22
 */
@Getter
@Setter
@TableName("private_message")
@ApiModel(value = "PrivateMessage对象", description = "")
public class Message implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableField("sender_id")
    private Integer senderId;

    @TableField("receiver_id")
    private Integer receiverId;

    @TableField("group_id")
    private Integer groupId;

    @TableField("send_time")
    private LocalDateTime sendTime;

    @TableField("message_type")
    private Integer messageType;

    @TableField("chat_type")
    private Integer chatType;

    @TableField("content")
    private String content;

    @TableField("seen")
    private Integer seen;


}
