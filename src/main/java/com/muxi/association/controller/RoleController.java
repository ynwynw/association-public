package com.muxi.association.controller;

import com.muxi.association.pojo.entity.Role;
import com.muxi.association.service.RoleService;
import com.muxi.association.util.BaseApiService;
import com.muxi.association.util.BaseResponse;
import com.muxi.association.util.ParameterDealUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZXW
 */
@RestController
@RequestMapping("/api/back/role")
public class RoleController extends BaseApiService {

    @Resource
    private RoleService roleService;

    @RequestMapping("/list")
    public BaseResponse getLabelTypeList(String authority, String role, Integer page, Integer limit) {
        authority = ParameterDealUtil.parameterNullHandle(authority);
        role = ParameterDealUtil.parameterNullHandle(role);
        List<Integer> list = ParameterDealUtil.pageParameterDeal(page, limit);
        return setResultSuccess(roleService.getRoleList(authority, role, Long.valueOf(list.get(0)), list.get(1)));
    }

    @RequestMapping("/option")
    public BaseResponse getLabelTypeOption() {
        return setResultSuccess(roleService.getRoleOption());
    }

    @PostMapping("/add")
    public BaseResponse addLabelType(@RequestBody Role role) {
        roleService.saveRole(role);
        return setResultSuccess();
    }

    @GetMapping("/modify/{id}")
    public BaseResponse modifyLabelType(@PathVariable("id") Integer id) {
        return setResultSuccess(roleService.getRoleOne(id));
    }

    @PostMapping("/update")
    public BaseResponse updateLabelType(@RequestBody Role role) {
        roleService.updateRoleOne(role);
        return setResultSuccess();
    }

    @GetMapping("/deletes")
    public BaseResponse deleteLabelTypes(String idStr) {
        List<Integer> ids = ParameterDealUtil.stringSplitArray(idStr);
        if (null == ids) {
            return setResultError();
        }
        roleService.deleteRoles(ids);
        return setResultSuccess();
    }
}
