package com.example.easychat.controller;

import com.example.easychat.data.dto.OneNewValue;
import com.example.easychat.data.fo.Result;
import com.example.easychat.data.vo.PersonalGrouping;
import com.example.easychat.service.impl.RelationshipServiceImpl;
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
@RequestMapping("/relationship")
public class RelationshipController {

    @Autowired
    private RelationshipServiceImpl relationshipService;

    @RequestMapping("grouping/{id}")
    public Result<List<String>> getPersonalGroupingTypes(@PathVariable Integer id) {
        return Result.depends(relationshipService.getPersonalGroupingTypes(id));
    }

    @RequestMapping("update_note")
    public Result<Boolean> updateNote(@RequestBody OneNewValue oneNewValue) {
        return Result.depends(relationshipService.updateNote(oneNewValue));
    }

    @RequestMapping("update_grouping")
    public Result<Boolean> updateGrouping(@RequestBody OneNewValue oneNewValue) {
        return Result.depends(relationshipService.updateGrouping(oneNewValue));
    }

    @RequestMapping("personal_grouping/{id}")
    public Result<List<PersonalGrouping>> getPersonalGrouping(@PathVariable Integer id) {
        return Result.depends(relationshipService.getPersonalGrouping(id));
    }

}
