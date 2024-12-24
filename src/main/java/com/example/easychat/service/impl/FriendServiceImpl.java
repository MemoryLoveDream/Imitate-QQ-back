package com.example.easychat.service.impl;

import com.example.easychat.data.dto.FriendGroupingType;
import com.example.easychat.data.dto.Modification;
import com.example.easychat.data.dto.We;
import com.example.easychat.data.entity.Friend;
import com.example.easychat.data.vo.FriendGrouping;
import com.example.easychat.data.vo.FriendInfo;
import com.example.easychat.mapper.FriendMapper;
import com.example.easychat.service.IFriendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wy
 * @since 2024-09-29
 */
@Slf4j
@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend>
        implements IFriendService {

    @Autowired
    private FriendMapper friendMapper;

    public FriendInfo getFriendInfo(We we) {
        return friendMapper.getFriendInfo(we);
    }

    @Override
    public List<String> listGroupingTypes(String id) {
        return friendMapper.listGroupingTypes(id);
    }

    @Override
    public Boolean updateNote(Modification modification) {
        return friendMapper.updateNote(modification);
    }

    @Override
    public Boolean updateGrouping(Modification modification) {
        return friendMapper.updateGrouping(modification);
    }

    @Override
    public List<FriendGrouping> listGrouping(String id) {
        List<FriendGrouping> list = friendMapper.listFriendGrouping(id);
        if (!list.isEmpty()) {
            for (FriendGrouping item : list) {
                item.setMembers(friendMapper.getMemberInfo(new FriendGroupingType(id, item.getName())));
            }
        }
        return list;
    }


}
