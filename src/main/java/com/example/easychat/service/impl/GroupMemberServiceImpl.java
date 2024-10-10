package com.example.easychat.service.impl;

import com.example.easychat.data.dto.OneNewValue;
import com.example.easychat.data.entity.GroupMember;
import com.example.easychat.mapper.GroupMemberMapper;
import com.example.easychat.service.IGroupMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wy
 * @since 2024-09-22
 */
@Service
public class GroupMemberServiceImpl extends ServiceImpl<GroupMemberMapper, GroupMember>
        implements IGroupMemberService {

    @Autowired
    private GroupMemberMapper groupMemberMapper;

    @Override
    public Boolean updateNickname(OneNewValue oneNewValue) {
        return groupMemberMapper.updateNickname(oneNewValue);
    }

    @Override
    public Boolean updateNote(OneNewValue oneNewValue) {
        return groupMemberMapper.updateNote(oneNewValue);
    }
}
