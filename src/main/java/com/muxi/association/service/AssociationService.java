package com.muxi.association.service;

import com.muxi.association.pojo.entity.Association;

import java.util.List;
import java.util.Map;

/**
 * @author ZXW
 */
public interface AssociationService {

    /**
     * 根据条件获取社团列表
     * @param name
     * @param pageNum
     * @param limit
     * @return
     */
    Map<String, Object> getAssociationList(String name, Long pageNum, Integer limit);

    /**
     * 获得所有社团
     * @return
     */
    List<Association> getAssociationAll();

    /**
     * 报存社团
     * @param association
     */
    void saveAssociation(Association association);

    /**
     * 通过id获取对象
     * @param id
     * @return
     */
    Association getAssociationOne(Integer id);

    /**
     * 更新社团对象
     * @param association
     */
    void updateAssociationOne(Association association);

    /**
     *  根据id删出
     * @param ids
     */
    void deleteAssociations(List<Integer> ids);
}
