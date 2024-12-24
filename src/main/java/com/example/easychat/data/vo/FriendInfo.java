package com.example.easychat.data.vo;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendInfo extends UserInfo {

    private String note;
    private String grouping;

}
