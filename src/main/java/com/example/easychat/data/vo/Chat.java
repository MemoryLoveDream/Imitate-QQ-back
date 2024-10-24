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
public class Chat implements Serializable {

    @TableField("chat_type")
    private Integer chatType;
    @TableField("sender_id")
    private Integer senderId;
    @TableField("send_time")
    private LocalDateTime sendTime;
    private String content;

}
