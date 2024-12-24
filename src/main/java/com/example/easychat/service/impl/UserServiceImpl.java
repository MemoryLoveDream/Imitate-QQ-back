package com.example.easychat.service.impl;

import com.example.easychat.constants.RedisConstant;
import com.example.easychat.data.dto.*;
import com.example.easychat.data.entity.User;
import com.example.easychat.data.vo.PersonalInfo;
import com.example.easychat.enums.VerificationEnum;
import com.example.easychat.mapper.UserMapper;
import com.example.easychat.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.easychat.utils.PasswordUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

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

    public boolean verify(Verification verification) {
        String id = verification.getId();
        if (id.equals(userMapper.getId(id))) {
            return false;
        }
        String code = UUID.randomUUID().toString().substring(0,4);
        Integer type = verification.getType();
        redisService.set(RedisConstant.ID_HEAD + id, code, 300);
        if (type.equals(VerificationEnum.EMAIL.getCode())) {
            Context context = new Context();
            context.setVariable("id", id);
            context.setVariable("code", code);
            String content = templateEngine.process("verify.html", context);
            return emailService.sendHtmlMail(id, "注册验证码", content, null);
        }
        else if(type.equals(VerificationEnum.SMS.getCode())) {
            return smsService.sendSms(id, code);
        }
        return false;
    }

    public boolean register(Register register) {
        String id = register.getId();
        if (id.equals(userMapper.getId(id))) {
            return false;
        }
        String code = redisService.get(RedisConstant.ID_HEAD + id);
        if (register.getCode().equals(code)) {
            String salt = RandomStringUtils.randomAlphanumeric(16);
            register.setCode(salt);
            register.setPassword(PasswordUtil.encrypt(salt, register.getPassword()));
            userMapper.savaRegister(register);
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
