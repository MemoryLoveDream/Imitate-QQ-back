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

/**
 * <p>
 * 
 * </p>
 *
 * @author wy
 * @since 2024-09-22
 */
@Getter
@Setter
@TableName("group")
@ApiModel(value = "Group对象", description = "")
public class Group implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableField("id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("head_url")
    private String headUrl;

    @TableField("introduction")
    private String introduction;

    @TableField("announcement")
    private String announcement;

    @TableField("create_time")
    private LocalDateTime createTime;


}
