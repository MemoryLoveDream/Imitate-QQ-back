package com.example.easychat.data.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupInfo implements Serializable {

    private String id;
    private String name;
    private String nickname;
    private String note;
    private Integer role;
    private String introduction;
    private String announcement;
    private Integer number;
    private String leader;
    private List<String> members;

}
