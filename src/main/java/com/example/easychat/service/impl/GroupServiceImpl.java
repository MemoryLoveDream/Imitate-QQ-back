package com.example.easychat.service.impl;

import com.example.easychat.data.dto.We;
import com.example.easychat.data.entity.Group;
import com.example.easychat.data.vo.GroupInfo;
import com.example.easychat.mapper.GroupMapper;
import com.example.easychat.mapper.GroupMemberMapper;
import com.example.easychat.service.IGroupService;
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
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements IGroupService {

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private GroupMemberMapper groupMemberMapper;

    @Override
    public GroupInfo getGroupInfo(We we) {
        GroupInfo groupInfo = groupMapper.getGroupInfo(we);
        groupInfo.setLeaderHeadUrl(groupMemberMapper.getLeaderHeadUrl(we.getYou()));
        groupInfo.setMemberHeadUrls(groupMemberMapper.getMemberHeadUrls(we.getYou()));
        return groupInfo;
    }

}
