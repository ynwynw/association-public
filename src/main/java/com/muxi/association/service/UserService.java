package com.muxi.association.service;

import com.muxi.association.pojo.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author ZXW
 */
public interface UserService {

    /**
     * 条件获取角色列表
     * @param username
     * @param credit
     * @param authority
     * @param pageNum
     * @param limit
     * @return
     */
    Map<String, Object> getUserRoleList(String username, Double credit, String authority, Long pageNum, Integer limit);

    /**
     * 报存角色信息
     * @param user
     */
    void saveUser(User user);

    /**
     * 通过id获取对象
     * @param id
     * @return
     */
    User getUserOne(Integer id);

    /**
     * 更新role对象
     * @param user
     */
    void updateUserOne(User user);

    /**
     * 修改用户当前状态
     * @param id
     * @param status
     */
    void updateUserStatus(Integer id, Integer status);

    /**
     * 用户编辑信息
     * @param user
     */
    void updatePersonInformation(User user);
    /**
     *  根据id删出
     * @param ids
     */
    void deleteUsers(List<Integer> ids);

}
