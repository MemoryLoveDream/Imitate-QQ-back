package com.example.easychat.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
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
 * @since 2024-09-29
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("relationship")
@ApiModel(value = "Relationship对象", description = "")
public class Relationship implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("i")
    private Integer i;

    @TableField("you")
    private Integer you;

    @ApiModelProperty("备注")
    @TableField("note")
    private String note;

    @TableField("grouping")
    private String grouping;

    @ApiModelProperty("亲密度")
    @TableField("intimacy")
    private Integer intimacy;


}
