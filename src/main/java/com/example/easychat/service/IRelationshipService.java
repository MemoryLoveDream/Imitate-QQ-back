package com.example.easychat.service;

import com.example.easychat.data.dto.OneNewValue;
import com.example.easychat.data.entity.Relationship;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.easychat.data.vo.PersonalGrouping;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wy
 * @since 2024-09-29
 */
public interface IRelationshipService extends IService<Relationship> {

    List<String> getPersonalGroupingTypes(Integer id);

    Boolean updateNote(OneNewValue oneNewValue);

    Boolean updateGrouping(OneNewValue oneNewValue);

    List<PersonalGrouping> getPersonalGrouping(Integer id);

}
