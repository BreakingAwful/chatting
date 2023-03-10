package com.sxrekord.chatting.dao;

import com.sxrekord.chatting.model.po.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Rekord
 * @date 2022/9/12 18:30
 */
@Mapper
public interface GroupDao {
    /**
     * 根据群组ID查询群组
     * @param id
     * @return
     */
    Group getGroupById(@Param("id") Long id);

    List<Group> searchGroupByName(@Param("name") String name);

    List<Group> listGroupByOwnerId(@Param("ownerId") Long ownerId);

    int insertGroup(Group group);
}
