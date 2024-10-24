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
public class NewMessage implements Serializable {

    @TableField("message_type")
    private Integer messageType;
    private Integer id;
    private Integer unread;
    private List<Chat> chats;

}
