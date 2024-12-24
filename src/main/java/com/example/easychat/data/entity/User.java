package com.example.easychat.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@TableName("user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("nickname")
    private String nickname;

    @TableField("password")
    private String password;

    @TableField("sex")
    private Integer sex;

    @TableField("signature")
    private String signature;

    @TableField("country")
    private String country;

    @TableField("location")
    private String location;

    @TableField("status")
    private Integer status;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    @TableField("last_off_time")
    private LocalDateTime lastOffTime;

}
