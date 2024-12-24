package com.example.easychat.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SignalEnum {

    CONNECTION(1, "连接"),
    DISCONNECTION(2, "断联"),
    MESSAGE(3, "消息"),
    TIME_CORRECTION(4, "时间校正"),
    PEER_ID_REQUEST(5, "peerId请求"),
    PEER_ID_SENDING(6, "peerId发送");

    private final Integer code;
    private final String name;

}
