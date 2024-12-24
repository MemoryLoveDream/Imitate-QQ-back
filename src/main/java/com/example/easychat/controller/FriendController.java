package com.example.easychat.controller;

import com.example.easychat.data.dto.Modification;
import com.example.easychat.data.dto.We;
import com.example.easychat.data.fo.Result;
import com.example.easychat.data.vo.FriendGrouping;
import com.example.easychat.data.vo.FriendInfo;
import com.example.easychat.service.impl.FriendServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wy
 * @since 2024-08-03
 */
@RestController
@RequestMapping("friend")
public class FriendController {

    @Autowired
    private FriendServiceImpl friendService;

    @RequestMapping("info")
    public Result<FriendInfo> friendInfo(@RequestBody We we) {
        return Result.depends(friendService.getFriendInfo(we));
    }

    @RequestMapping("grouping_type/{id}")
    public Result<List<String>> listGroupingTypes(@PathVariable String id) {
        return Result.depends(friendService.listGroupingTypes(id));
    }

    @RequestMapping("update_note")
    public Result<Boolean> updateNote(@RequestBody Modification modification) {
        return Result.depends(friendService.updateNote(modification));
    }

    @RequestMapping("update_grouping")
    public Result<Boolean> updateGrouping(@RequestBody Modification modification) {
        return Result.depends(friendService.updateGrouping(modification));
    }

    @RequestMapping("grouping/{id}")
    public Result<List<FriendGrouping>> listGrouping(@PathVariable String id) {
        return Result.depends(friendService.listGrouping(id));
    }

}
