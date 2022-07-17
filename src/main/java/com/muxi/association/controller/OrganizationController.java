package com.muxi.association.controller;

import com.muxi.association.pojo.entity.Organization;
import com.muxi.association.service.OrganizationService;
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
@RequestMapping("/api/back/organize")
public class OrganizationController extends BaseApiService {

    @Resource
    private OrganizationService organizationService;

    @RequestMapping("/list")
    public BaseResponse getOrganizationList(String name, Integer page, Integer limit) {
        name = ParameterDealUtil.parameterNullHandle(name);
        List<Integer> list = ParameterDealUtil.pageParameterDeal(page, limit);
        return setResultSuccess(organizationService.getOrganizationList(name, Long.valueOf(list.get(0)), list.get(1)));
    }

    @RequestMapping("/all")
    public BaseResponse getOrganizationAll() {
        return setResultSuccess(organizationService.getOrganizationAll());
    }

    @PostMapping("/add")
    public BaseResponse addOrganization(@RequestBody Organization organization) {
        organizationService.saveOrganization(organization);
        return setResultSuccess();
    }

    @GetMapping("/modify/{id}")
    public BaseResponse modifyOrganization(@PathVariable("id") Integer id) {
        return setResultSuccess(organizationService.getOrganizationOne(id));
    }

    @PostMapping("/update")
    public BaseResponse updateOrganization(@RequestBody Organization organization) {
        organizationService.updateOrganizationOne(organization);
        return setResultSuccess();
    }

    @GetMapping("/deletes")
    public BaseResponse deleteOrganizations(String idStr) {
        List<Integer> ids = ParameterDealUtil.stringSplitArray(idStr);
        if (null == ids) {
            return setResultError();
        }
        organizationService.deleteOrganizations(ids);
        return setResultSuccess();
    }
}
