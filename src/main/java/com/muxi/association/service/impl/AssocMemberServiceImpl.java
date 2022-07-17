package com.muxi.association.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.muxi.association.enums.ExamineStatusEnum;
import com.muxi.association.mapper.AssocMemberMapper;
import com.muxi.association.mapper.RoleMapper;
import com.muxi.association.pojo.entity.AssocMember;
import com.muxi.association.pojo.entity.Role;
import com.muxi.association.pojo.vo.AssocMemberVo;
import com.muxi.association.service.AssocMemberService;
import com.muxi.association.service.RoleService;
import com.muxi.association.util.PagingDealUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ZXW
 */
@Service
public class AssocMemberServiceImpl implements AssocMemberService {

    @Resource
    private AssocMemberMapper assocMemberMapper;

    @Resource
    private RoleService roleService;

    @Override
    public Map<String, Object> getAssociationMemberList(String name, String status, String department, String username, Long pageNum, Integer limit) {
        List<AssocMemberVo> assocMemberVos = assocMemberMapper.selectAssocMemberListByCondition(name, ExamineStatusEnum.catchValue(status), department, username, pageNum-1, limit);
        Long total = assocMemberMapper.selectAssocMemberCountByCondition(name, ExamineStatusEnum.catchValue(status), department, username);
        return PagingDealUtil.pageReturnValueDeal(assocMemberVos, total, limit);
    }

    @Override
    public void saveAssocMember(AssocMember assocMember) {
        assocMemberMapper.insert(assocMember);
    }

    @Override
    public AssocMember getAssocMemberByUserIdAssociationId(Integer userId, Integer associationId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (userId != null) {
            queryWrapper.eq("user_id", userId);
        }
        if (userId != null) {
            queryWrapper.eq("association_id", associationId);
        }
        return assocMemberMapper.selectOne(queryWrapper);
    }

    @Override
    public AssocMemberVo getAssocMemberVoOne(Integer id) {
        return assocMemberMapper.selectAssocMemberVoById(id);
    }

    @Override
    public AssocMember getAssocMemberOne(Integer id) {
        return assocMemberMapper.selectById(id);
    }

    @Override
    public void updateAssocMemberOne(Integer id, String department, String role) {
        AssocMember assocMemberGoal = assocMemberMapper.selectById(id);
        assocMemberGoal.setDepartment(department);
        Role roleObject = roleService.getRoleByRole(role);
        assocMemberGoal.setRoleId(roleObject.getId());
        assocMemberMapper.updateById(assocMemberGoal);
    }

    @Override
    public void updateExamineStatus(Integer id, String status) {
        AssocMember member = assocMemberMapper.selectById(id);
        if (ExamineStatusEnum.catchValue(status) == ExamineStatusEnum.REJECTED) {
            assocMemberMapper.deleteById(id);
        }
        member.setStatus(ExamineStatusEnum.catchValue(status));
        assocMemberMapper.updateById(member);
    }

    @Override
    public void deleteAssocMembers(List<Integer> ids) {
        assocMemberMapper.deleteBatchIds(ids);
    }
}
