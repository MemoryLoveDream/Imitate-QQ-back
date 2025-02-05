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
public class Group implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("name")
    private String name;

    @TableField("introduction")
    private String introduction;

    @TableField("announcement")
    private String announcement;

    @TableField("create_time")
    private LocalDateTime createTime;


}
