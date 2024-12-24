package com.example.easychat.controller;

import com.example.easychat.data.dto.We;
import com.example.easychat.data.fo.Result;
import com.example.easychat.data.vo.GroupInfo;
import com.example.easychat.enums.RelationshipEnum;
import com.example.easychat.service.impl.AssetsServiceImpl;
import com.example.easychat.service.impl.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private AssetsServiceImpl assetsService;

    @RequestMapping("group_info")
    public Result<GroupInfo> getGroupInfo(@RequestBody We we) {
        return Result.depends(groupService.getGroupInfo(we));
    }

    @RequestMapping("avatar/{id}")
    public ResponseEntity<InputStreamResource> head(@PathVariable String id) {
        return assetsService.getAvatarJpg(RelationshipEnum.GROUP.getCode(), id);
    }

}
