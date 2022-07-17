package com.muxi.association.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.muxi.association.enums.ExamineStatusEnum;
import com.muxi.association.pojo.entity.AssocMember;
import com.muxi.association.pojo.vo.AssocMemberVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZXW
 */
public interface AssocMemberMapper extends BaseMapper<AssocMember> {

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
    List<AssocMemberVo> selectAssocMemberListByCondition(@Param("name") String name, @Param("status")ExamineStatusEnum status, @Param("department") String department, @Param("username") String username, @Param("pageNum") Long pageNum, @Param("limit") Integer limit);

    /**
     * 根据条件获取社团成员数目
     * @param name
     * @param status
     * @param department
     * @param username
     * @return
     */
    Long selectAssocMemberCountByCondition(@Param("name") String name, @Param("status")ExamineStatusEnum status, @Param("department") String department, @Param("username") String username);

    /**
     * 根据id获取Vo对象
     * @param id
     * @return
     */
    AssocMemberVo selectAssocMemberVoById(Integer id);
}
