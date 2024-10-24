package com.example.easychat.data.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberInfo implements Serializable {

    private Integer type;
    private Integer id;
    private String nickname;
    @TableField("head_url")
    private String headUrl;
    private String signature;

}
