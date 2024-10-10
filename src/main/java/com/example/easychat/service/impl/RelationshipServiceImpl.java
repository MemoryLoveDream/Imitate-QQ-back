package com.example.easychat.service.impl;

import com.example.easychat.data.dto.OneNewValue;
import com.example.easychat.data.entity.Relationship;
import com.example.easychat.mapper.RelationshipMapper;
import com.example.easychat.service.IRelationshipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wy
 * @since 2024-09-29
 */
@Service
public class RelationshipServiceImpl extends ServiceImpl<RelationshipMapper, Relationship>
        implements IRelationshipService {

    @Autowired
    private RelationshipMapper relationshipMapper;

    @Override
    public List<String> getSingleGroupingTypes(Integer id) {
        return relationshipMapper.getGroupingTypes(id);
    }

    @Override
    public Boolean updateNote(OneNewValue oneNewValue) { return relationshipMapper.updateNote(oneNewValue); }

    @Override
    public Boolean updateGrouping(OneNewValue oneNewValue) { return relationshipMapper.updateGrouping(oneNewValue); }


}
