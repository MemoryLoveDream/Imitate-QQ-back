package com.example.easychat.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@TableName("user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableField("id")
    @TableId(type = IdType.AUTO)
    private String id;

    @TableField("head_url")
    private String headUrl;

    @TableField("nickname")
    private String nickname;

    @TableField("password")
    private String password;

    @TableField("email")
    private String email;

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
