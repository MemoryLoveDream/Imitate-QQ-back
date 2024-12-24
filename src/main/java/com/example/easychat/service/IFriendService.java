package com.example.easychat.service;

import com.example.easychat.data.dto.Modification;
import com.example.easychat.data.entity.Friend;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.easychat.data.vo.FriendGrouping;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wy
 * @since 2024-09-29
 */
public interface IFriendService extends IService<Friend> {

    List<String> listGroupingTypes(String id);

    Boolean updateNote(Modification modification);

    Boolean updateGrouping(Modification modification);

    List<FriendGrouping> listGrouping(String id);

}
