package com.example.easychat.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.example.easychat.data.dto.Login;
import com.example.easychat.data.dto.Register;
import com.example.easychat.data.dto.We;
import com.example.easychat.data.entity.User;
import com.example.easychat.data.vo.SingleInfo;
import com.example.easychat.mapper.UserMapper;
import com.example.easychat.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(Login login) {
        return userMapper.getNickname(login) != null ;
    }

    @Override
    public Integer register(Register register) {
        userMapper.insert(register);
        return register.getId();
    }

    public SingleInfo getSingleInfo(We we) {
        return userMapper.getSingleInfo(we);
    }

}
