package com.example.easychat.mapper;

import com.example.easychat.data.dto.We;
import com.example.easychat.data.entity.Group;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.easychat.data.vo.GroupInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

}
