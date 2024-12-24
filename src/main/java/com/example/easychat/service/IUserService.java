package com.example.easychat.service;

import com.example.easychat.data.dto.Login;
import com.example.easychat.data.dto.Register;
import com.example.easychat.data.dto.We;
import com.example.easychat.data.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.easychat.data.vo.FriendInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wy
 * @since 2024-09-22
 */
public interface IUserService extends IService<User> {

    boolean login(Login login);

    boolean register(Register register);

}
