package com.muxi.association.service;

import com.muxi.association.pojo.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * @author ZXW
 */

public interface RoleService {
    /**
     * 条件获取角色列表
     * @param authority
     * @param role
     * @param pageNum
     * @param limit
     * @return
     */
    Map<String, Object> getRoleList(String authority, String role, Long pageNum, Integer limit);

    /**
     * 获取角色权限选择(校级管理员:{}, 院级管理员:{}, ....)
     * @return
     */
    Map<String, Object> getRoleOption();

    /**
     * 报存角色信息
     * @param role
     */
    void saveRole(Role role);

    /**
     * 通过id获取对象
     * @param id
     * @return
     */
    Role getRoleOne(Integer id);

    /**
     * 通过角色获取对象
     * @param role
     * @return
     */
    Role getRoleOne(String role);

    /**
     * 通过角色字段获取对象
     * @param role
     * @return
     */
    Role getRoleByRole(String role);

    /**
     * 更新role对象
     * @param role
     */
    void updateRoleOne(Role role);

    /**
     *  根据id删出
     * @param ids
     */
    void deleteRoles(List<Integer> ids);
}
