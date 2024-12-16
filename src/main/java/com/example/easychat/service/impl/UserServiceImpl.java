package com.example.easychat.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.example.easychat.data.dto.Login;
import com.example.easychat.data.dto.Password;
import com.example.easychat.data.dto.Register;
import com.example.easychat.data.dto.We;
import com.example.easychat.data.entity.User;
import com.example.easychat.data.vo.PersonalInfo;
import com.example.easychat.mapper.UserMapper;
import com.example.easychat.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.easychat.utils.PasswordUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;
import java.util.UUID;

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
    private RedisService<String> redisService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SmsService smsService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private HdfsService hdfsService;

    public void verify(String type, String id) {
        String code = UUID.randomUUID().toString().substring(0,4);
        redisService.set(id, code, 60);
        if (type.equals("email")) {
            Context context = new Context();
            context.setVariable("id", id);
            context.setVariable("code", code);
            String content = templateEngine.process("verify.html", context);
            emailService.sendHtmlMail(id, "注册验证码", content, null);
        }
        else if(type.equals("sms")) {
            smsService.sendSms(id, code);
        }
    }

    public boolean register(Register register) {
        String code = redisService.get(register.getId());
        if (code.equals(register.getCode())) {
            String salt = RandomStringUtils.randomAlphanumeric(16);
            register.setPassword(PasswordUtil.encrypt(salt, register.getPassword()));
            return true;
        }
        return false;
    }

    @Override
    public boolean login(Login login) {
        Password password = userMapper.getPassword(login);
        return login.getPassword().equals(PasswordUtil.decrypt(password.getSalt(), password.getPassword()));
    }

    public boolean destroy(Login login) {
        return true;
    }

    public PersonalInfo getPersonalInfo(We we) {
        return userMapper.getPersonalInfo(we);
    }

}
