package com.muxi.association.controller;

import com.muxi.association.pojo.entity.Association;
import com.muxi.association.service.AssociationService;
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
@RequestMapping("/api/back/association/info")
public class AssociationController extends BaseApiService {

    @Resource
    private AssociationService associationService;

    @RequestMapping("/list")
    public BaseResponse getAssociationList(String name, Integer page, Integer limit) {
        name = ParameterDealUtil.parameterNullHandle(name);
        List<Integer> list = ParameterDealUtil.pageParameterDeal(page, limit);
        return setResultSuccess(associationService.getAssociationList(name, Long.valueOf(list.get(0)), list.get(1)));
    }

    @RequestMapping("/all")
    public BaseResponse getAssociationAll() {
        return setResultSuccess(associationService.getAssociationAll());
    }

    @PostMapping("/add")
    public BaseResponse addAssociation(@RequestBody Association association) {
        associationService.saveAssociation(association);
        return setResultSuccess();
    }

    @GetMapping("/modify/{id}")
    public BaseResponse modifyAssociation(@PathVariable("id") Integer id) {
        return setResultSuccess(associationService.getAssociationOne(id));
    }

    @PostMapping("/update")
    public BaseResponse updateAssociation(@RequestBody Association association) {
        associationService.updateAssociationOne(association);
        return setResultSuccess();
    }

    @GetMapping("/deletes")
    public BaseResponse deleteAssociations(String idStr) {
        List<Integer> ids = ParameterDealUtil.stringSplitArray(idStr);
        if (null == ids) {
            return setResultError();
        }
        associationService.deleteAssociations(ids);
        return setResultSuccess();
    }
}
