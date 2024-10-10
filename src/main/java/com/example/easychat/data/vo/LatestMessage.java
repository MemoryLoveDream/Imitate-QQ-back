package com.example.easychat.data.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LatestMessage implements Serializable {

    private Integer senderId;
    private String nickname;
    private String headUrl;
    private LocalDateTime sendTime;
    private Integer messageType;
    private Integer chatType;
    private String content;
    private Integer unread;

}
