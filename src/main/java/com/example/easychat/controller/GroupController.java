package com.example.easychat.controller;

import com.example.easychat.data.dto.We;
import com.example.easychat.data.fo.Result;
import com.example.easychat.data.vo.GroupInfo;
import com.example.easychat.service.impl.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wy
 * @since 2024-09-22
 */
@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupServiceImpl groupService;

    @RequestMapping("group_info")
    public Result<GroupInfo> getGroupInfo(@RequestBody We we) {
        return Result.depends(groupService.getGroupInfo(we));
    }

}
