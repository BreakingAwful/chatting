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

    /**
     * 根据名字查找群组
     * @param name
     * @return
     */
    List<Group> searchGroupByName(@Param("name") String name);

    /**
     * 根据ownerId列出群组
     * @param ownerId
     * @return
     */
    List<Group> listGroupByOwnerId(@Param("ownerId") Long ownerId);

    /**
     * 插入群组
     * @param group
     * @return
     */
    int insertGroup(Group group);

    /**
     * 根据id删除群组
     * @param id
     * @return
     */
    int deleteGroup(@Param("id") Long id);
}
