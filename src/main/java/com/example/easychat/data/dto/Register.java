package com.example.easychat.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Register implements Serializable {

    String id;
    String nickname;
    String password;
    String code;

}
