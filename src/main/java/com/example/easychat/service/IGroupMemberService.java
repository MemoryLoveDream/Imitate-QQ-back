package com.example.easychat.service;

import com.example.easychat.data.dto.OneNewValue;
import com.example.easychat.data.entity.GroupMember;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wy
 * @since 2024-09-22
 */
public interface IGroupMemberService extends IService<GroupMember> {

    Boolean updateNickname(OneNewValue oneNewValue);

    Boolean updateNote(OneNewValue oneNewValue);

}