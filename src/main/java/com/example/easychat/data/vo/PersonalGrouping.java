package com.example.easychat.data.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalGrouping implements Serializable {

    private String name;
    @TableField("online_number")
    private Integer onlineNumber;
    private Integer number;
    private List<MemberInfo> members;

}
