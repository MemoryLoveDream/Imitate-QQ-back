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
 * @since 2024-09-22
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("group_member")
public class GroupMember implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableField("group_id")
    private String groupId;

    @TableField("member_id")
    private String memberId;

    @TableField("nickname")
    private String nickname;

    @TableField("note")
    private String note;

    @TableField("role")
    private Integer role;


}
