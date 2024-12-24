package com.example.easychat.mapper;

import com.example.easychat.data.dto.FriendGroupingType;
import com.example.easychat.data.dto.MemberRole;
import com.example.easychat.data.dto.We;
import com.example.easychat.data.entity.Group;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.easychat.data.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wy
 * @since 2024-09-22
 */
@Mapper
public interface GroupMapper extends BaseMapper<Group> {

    GroupInfo getGroupInfo(We we);

    Integer listGroupGrouping(MemberRole memberRole);

    List<GroupGroupingMember> getMemberInfo(MemberRole memberRole);

}
