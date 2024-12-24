package com.example.easychat.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wy
 * @since 2024-09-29
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("friend")
public class Friend implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId
    private String i;

    private String you;

    @TableField("note")
    private String note;

    @TableField("grouping")
    private String grouping;

    @TableField("intimacy")
    private Integer intimacy;


}
