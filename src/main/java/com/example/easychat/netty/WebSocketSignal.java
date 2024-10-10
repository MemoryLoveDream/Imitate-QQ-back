package com.example.easychat.netty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebSocketSignal implements Serializable {

    public static Integer FIRST_CONNECTION = 1;
    public static Integer SEND_CHAT = 2;
    public static Integer MODIFY_INFO = 3;
    public static Integer DISCONNECTION = 4;

    private Integer signalType;
    private String content;

    @Data
    @AllArgsConstructor
    public static class Chat implements Serializable {

        private Integer senderId;
        private String headUrl;
        private Integer receiverId;
        private LocalDateTime sendTime;
        private Integer messageType;
        private Integer chatType;
        private String content;

        public Chat() {
            sendTime = LocalDateTime.now();
        }

    }

}
