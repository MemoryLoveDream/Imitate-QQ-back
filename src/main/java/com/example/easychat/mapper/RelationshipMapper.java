package com.example.easychat.mapper;

import com.example.easychat.data.dto.IS;
import com.example.easychat.data.dto.OneNewValue;
import com.example.easychat.data.entity.Relationship;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.easychat.data.vo.MemberInfo;
import com.example.easychat.data.vo.PersonalGrouping;
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
public interface RelationshipMapper extends BaseMapper<Relationship> {

    @Select("select distinct `grouping` from relationship where i=#{id}")
    List<String> getGroupingTypes(Integer id);

    List<PersonalGrouping> getPersonalGrouping(Integer id);

    List<MemberInfo> getMemberInfo(IS is);

    @Update("update relationship set note=#{newValue} where i=#{i} and you=#{you}")
    Boolean updateNote(OneNewValue oneNewValue);

    @Update("update relationship set `grouping`=#{newValue} where i=#{i} and you=#{you}")
    Boolean updateGrouping(OneNewValue oneNewValue);

}
