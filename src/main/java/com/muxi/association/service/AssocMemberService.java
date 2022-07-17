package com.muxi.association.service;

import com.muxi.association.pojo.entity.AssocMember;
import com.muxi.association.pojo.vo.AssocMemberVo;

import java.util.List;
import java.util.Map;

/**
 * @author ZXW
 */
public interface AssocMemberService {

    /**
     * 根据条件获取社团成员列表
     * @param name
     * @param status
     * @param department
     * @param username
     * @param pageNum
     * @param limit
     * @return
     */
    Map<String, Object> getAssociationMemberList(String name, String status, String department, String username, Long pageNum, Integer limit);

    /**
     * 报存社团
     * @param assocMember
     */
    void saveAssocMember(AssocMember assocMember);

    /**
     * 通过userId和AssociationId获取对象
     * @param userId
     * @param associationId
     * @return
     */
    AssocMember getAssocMemberByUserIdAssociationId(Integer userId, Integer associationId);

    /**
     * 通过id获取Vo对象
     * @param id
     * @return
     */
    AssocMemberVo getAssocMemberVoOne(Integer id);

    /**
     * 通过id获取entity对象
     * @param id
     * @return
     */
    AssocMember getAssocMemberOne(Integer id);

    /**
     * 更新社团成员对象
     * @param id
     * @param department
     * @param role
     */
    void updateAssocMemberOne(Integer id, String department, String role);

    /**
     * 更新审核状态
     * @param id
     * @param status
     */
    void updateExamineStatus(Integer id, String status);

    /**
     *  根据id删出
     * @param ids
     */
    void deleteAssocMembers(List<Integer> ids);
}
