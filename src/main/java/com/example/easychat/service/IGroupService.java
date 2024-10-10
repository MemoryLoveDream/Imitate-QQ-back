package com.example.easychat.service;

import com.example.easychat.data.dto.We;
import com.example.easychat.data.entity.Group;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.easychat.data.vo.GroupInfo;
import com.example.easychat.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wy
 * @since 2024-09-22
 */
public interface IGroupService extends IService<Group> {

    GroupInfo getGroupInfo(We we);

}
