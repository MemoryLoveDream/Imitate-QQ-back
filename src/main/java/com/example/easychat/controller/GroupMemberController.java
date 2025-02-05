package com.example.easychat.controller;

import com.example.easychat.data.dto.Modification;
import com.example.easychat.data.fo.Result;
import com.example.easychat.service.impl.GroupMemberServiceImpl;
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
 * @since 2024-08-03
 */
@RestController
@RequestMapping("/group_member")
public class GroupMemberController {

    @Autowired
    private GroupMemberServiceImpl groupMemberService;

    @RequestMapping("update_note")
    public Result<Boolean> updateNote(@RequestBody Modification modification) {
        return Result.depends(groupMemberService.updateNote(modification));
    }

    @RequestMapping("update_nickname")
    public Result<Boolean> updateNickname(@RequestBody Modification modification) {
        return Result.depends(groupMemberService.updateNickname(modification));
    }

}
