package com.example.easychat.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebSocketSignal implements Serializable {

    private Integer signalType;
    private String content;

}
