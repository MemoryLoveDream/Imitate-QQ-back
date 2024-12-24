package com.example.easychat.mapper;

import com.example.easychat.data.dto.OneNewValue;
import com.example.easychat.data.entity.GroupMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
 * @since 2024-09-22
 */
@Mapper
public interface GroupMemberMapper extends BaseMapper<GroupMember> {

    @Select("select member_id from group_member where group_id=#{id} AND `role`=3")
    String getLeader(String id);

    @Select("select member_id from group_member where group_id=#{id} AND `role`!=3")
    List<String> getMembers(String id);

    @Update("update group_member set nickname=#{newValue} where group_id=#{you} and member_id={i}")
    Boolean updateNickname(OneNewValue oneNewValue);

    @Update("update group_member set note=#{newValue} where group_id=#{you} and member_id={i}")
    Boolean updateNote(OneNewValue oneNewValue);

}
