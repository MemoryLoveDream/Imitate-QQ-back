package com.example.easychat.data.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {

    private Integer id;
    private String nickname;
    private String headUrl;
    private String email;
    private Integer sex;
    private String signature;
    private String country;
    private String location;
    private Integer status;

}
