package com.muxi.association.controller;

import com.muxi.association.pojo.entity.LabelType;
import com.muxi.association.service.LabelTypeService;
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
@RequestMapping("/api/back/label/type")
public class LabelTypeController extends BaseApiService {

    @Resource
    private LabelTypeService labelTypeService;

    @RequestMapping("/list")
    public BaseResponse getLabelTypeList(String type, Integer page, Integer limit) {
        type = ParameterDealUtil.parameterNullHandle(type);
        List<Integer> list = ParameterDealUtil.pageParameterDeal(page, limit);
        return setResultSuccess(labelTypeService.getLabelTypeList(type, Long.valueOf(list.get(0)), list.get(1)));
    }

    @RequestMapping("/all")
    public BaseResponse getLabelTypeAll() {
        return setResultSuccess(labelTypeService.getLabelTypeAll());
    }

    @PostMapping("/add")
    public BaseResponse addLabelType(@RequestBody LabelType labelType) {
        labelTypeService.saveLabelType(labelType);
        return setResultSuccess();
    }

    @GetMapping("/modify/{id}")
    public BaseResponse modifyLabelType(@PathVariable("id") Integer id) {
        return setResultSuccess(labelTypeService.getLabelTypeOne(id));
    }

    @PostMapping("/update")
    public BaseResponse updateLabelType(@RequestBody LabelType labelType) {
        labelTypeService.updateLabelTypeOne(labelType);
        return setResultSuccess();
    }

    @GetMapping("/deletes")
    public BaseResponse deleteLabelTypes(String idStr) {
        List<Integer> ids = ParameterDealUtil.stringSplitArray(idStr);
        if (null == ids) {
            return setResultError();
        }
        labelTypeService.deleteLabelTypes(ids);
        return setResultSuccess();
    }
}
