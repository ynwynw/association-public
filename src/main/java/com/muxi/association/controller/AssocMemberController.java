package com.muxi.association.controller;

import com.muxi.association.enums.ExamineStatusEnum;
import com.muxi.association.pojo.entity.AssocMember;
import com.muxi.association.pojo.entity.User;
import com.muxi.association.service.AssocMemberService;
import com.muxi.association.util.BaseApiService;
import com.muxi.association.util.BaseResponse;
import com.muxi.association.util.ParameterDealUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ZXW
 */
@RestController
@RequestMapping("/api/back/association/member")
public class AssocMemberController extends BaseApiService {

    @Resource
    private AssocMemberService assocMemberService;

    @RequestMapping("/list")
    public BaseResponse getAssocMemberList(String name, String status, String department, String username, Integer page, Integer limit) {
        name = ParameterDealUtil.parameterNullHandle(name);
        status = ParameterDealUtil.parameterNullHandle(status);
        department = ParameterDealUtil.parameterNullHandle(department);
        username = ParameterDealUtil.parameterNullHandle(username);
        List<Integer> list = ParameterDealUtil.pageParameterDeal(page, limit);
        return setResultSuccess(assocMemberService.getAssociationMemberList(name, status, department, username, Long.valueOf(list.get(0)), list.get(1)));
    }

    @PostMapping("/add")
    public BaseResponse addAssocMember(@RequestBody AssocMember assocMember, HttpServletRequest request) {
        Integer userId = ((User) request.getSession().getAttribute("user")).getId();
        AssocMember assocMemberExist = assocMemberService.getAssocMemberByUserIdAssociationId(userId, assocMember.getAssociationId());
        if (assocMemberExist == null) {
            assocMember.setUserId(userId);
            assocMember.setStatus(ExamineStatusEnum.UNDER_REVIEW);
            assocMemberService.saveAssocMember(assocMember);
            return setResultSuccess("加入成功");
        }
        if (assocMemberExist.getStatus() == ExamineStatusEnum.UNDER_REVIEW) {
            return setResultSuccess("您已经申请,请等待审核");
        } else {
            return setResultSuccess("您已经加入,无需重复申请");
        }
    }

    @GetMapping("/modify/{id}")
    public BaseResponse modifyAssocMember(@PathVariable("id") Integer id) {
        return setResultSuccess(assocMemberService.getAssocMemberVoOne(id));
    }

    @PostMapping("/update")
    public BaseResponse updateAssocMember(Integer id, String department, String role) {
        department = ParameterDealUtil.parameterNullHandle(department);
        role = ParameterDealUtil.parameterNullHandle(role);
        assocMemberService.updateAssocMemberOne(id, department, role);
        return setResultSuccess();
    }

    @PostMapping("/examine")
    public BaseResponse dealExamine(Integer id, String status) {
        assocMemberService.updateExamineStatus(id, status);
        return setResultSuccess();
    }

    @GetMapping("/deletes")
    public BaseResponse deleteAssocMembers(String idStr) {
        List<Integer> ids = ParameterDealUtil.stringSplitArray(idStr);
        if (null == ids) {
            return setResultError();
        }
        assocMemberService.deleteAssocMembers(ids);
        return setResultSuccess();
    }
}
