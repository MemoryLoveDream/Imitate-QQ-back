package com.example.easychat.mapper;

import com.example.easychat.data.dto.FriendGroupingType;
import com.example.easychat.data.dto.Modification;
import com.example.easychat.data.dto.We;
import com.example.easychat.data.entity.Friend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.easychat.data.vo.FriendGroupingMember;
import com.example.easychat.data.vo.FriendGrouping;
import com.example.easychat.data.vo.FriendInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wy
 * @since 2024-09-29
 */
@Mapper
public interface FriendMapper extends BaseMapper<Friend> {

    FriendInfo getFriendInfo(We we);

    @Select("select distinct `grouping` from friend where i=#{id}")
    List<String> listGroupingTypes(String id);

    List<FriendGrouping> listFriendGrouping(String id);

    List<FriendGroupingMember> getMemberInfo(FriendGroupingType friendGroupingType);

    @Update("update friend set note=#{newValue} where i=#{i} and you=#{you}")
    Boolean updateNote(Modification modification);

    @Update("update friend set `grouping`=#{newValue} where i=#{i} and you=#{you}")
    Boolean updateGrouping(Modification modification);

}
