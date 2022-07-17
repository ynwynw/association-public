package com.muxi.association.service;

import com.muxi.association.pojo.entity.ActivityType;
import com.muxi.association.pojo.entity.Organization;

import java.util.List;
import java.util.Map;

/**
 * @author ZXW
 */
public interface OrganizationService {

    /**
     *  获取组织列表
     * @param name
     * @param pageNum
     * @param limit
     * @return
     */
    Map<String, Object> getOrganizationList(String name, Long pageNum, Integer limit);

    /**
     * 获得所有活动类型
     * @return
     */
    List<Organization> getOrganizationAll();

    /**
     * 插入组织对象
     * @param organization
     */
    void saveOrganization(Organization organization);

    /**
     * 通过id获取对象
     * @param id
     * @return
     */
    Organization getOrganizationOne(Integer id);

    /**
     * 更新组织对象
     * @param organization
     */
    void updateOrganizationOne(Organization organization);

    /**
     *  根据id删出
     * @param ids
     */
    void deleteOrganizations(List<Integer> ids);
}
