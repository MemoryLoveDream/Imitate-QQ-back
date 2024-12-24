package com.example.easychat.data.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {

    private String id;
    private String nickname;
    private Integer sex;
    private String signature;
    private String country;
    private String location;
    private Integer status;

}
