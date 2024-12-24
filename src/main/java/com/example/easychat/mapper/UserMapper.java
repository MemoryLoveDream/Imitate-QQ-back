package com.example.easychat.mapper;

import com.example.easychat.data.dto.Login;
import com.example.easychat.data.dto.Register;
import com.example.easychat.data.dto.We;
import com.example.easychat.data.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.easychat.data.dto.Password;
import com.example.easychat.data.vo.FriendInfo;
import org.apache.ibatis.annotations.Insert;
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
public interface UserMapper extends BaseMapper<User> {

    @Insert("insert into user(id,nickname,salt,password) values(#{id},#{nickname},#{code},#{password})")
    void savaRegister(Register register);

    @Select("select salt,password from user where id=#{id}")
    Password getPassword(Login login);

    @Select("select id from user where id=#{id}")
    String getId(String id);

}
