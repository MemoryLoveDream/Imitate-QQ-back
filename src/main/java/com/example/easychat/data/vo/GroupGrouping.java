package com.example.easychat.data.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupGrouping implements Serializable {

    private String name;
    private Integer number;
    private List<GroupGroupingMember> members;

}
