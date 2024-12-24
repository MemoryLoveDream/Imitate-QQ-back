package com.example.easychat.service.impl;

import com.example.easychat.data.dto.FriendGroupingType;
import com.example.easychat.data.dto.MemberRole;
import com.example.easychat.data.dto.We;
import com.example.easychat.data.entity.Group;
import com.example.easychat.data.vo.GroupGrouping;
import com.example.easychat.data.vo.GroupInfo;
import com.example.easychat.enums.MemberRoleEnum;
import com.example.easychat.mapper.GroupMapper;
import com.example.easychat.mapper.GroupMemberMapper;
import com.example.easychat.service.IGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wy
 * @since 2024-09-22
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements IGroupService {

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private GroupMemberMapper groupMemberMapper;

    @Override
    public GroupInfo getGroupInfo(We we) {
        GroupInfo groupInfo = groupMapper.getGroupInfo(we);
        if(groupInfo != null) {
            groupInfo.setLeader(groupMemberMapper.getLeader(we.getYou()));
            groupInfo.setMembers(groupMemberMapper.getMembers(we.getYou()));
        }
        return groupInfo;
    }

    //@Override
    public List<GroupGrouping> listGrouping(String id) {
        List<MemberRoleEnum> roles = List.of(MemberRoleEnum.ACTIVIST,
                MemberRoleEnum.LEADER,
                MemberRoleEnum.ADMIN,
                MemberRoleEnum.MEMBER);
        List<GroupGrouping> list = new ArrayList<>();
        for (MemberRoleEnum role : roles) {
            list.add(new GroupGrouping(role.getName(),
                    groupMapper.listGroupGrouping(new MemberRole(id, role.getCode())),
                    groupMapper.getMemberInfo(new MemberRole(id, role.getCode()))));
        }
        return list;
    }

}
