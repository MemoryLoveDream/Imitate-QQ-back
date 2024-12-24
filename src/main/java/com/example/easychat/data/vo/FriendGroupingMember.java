package com.example.easychat.data.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendGroupingMember implements Serializable {

    private Integer relationshipType;
    private String id;
    private String nickname;
    private String note;
    private String signature;

}
