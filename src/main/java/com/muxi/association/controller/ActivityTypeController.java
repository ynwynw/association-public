package com.muxi.association.controller;

import com.muxi.association.pojo.entity.ActivityType;
import com.muxi.association.service.ActivityTypeService;
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
@RequestMapping("/api/back/activity/type")
public class ActivityTypeController extends BaseApiService {

    @Resource
    private ActivityTypeService activityTypeService;

    @RequestMapping("/list")
    public BaseResponse getActivityTypeList(String type, Integer page, Integer limit) {
        type = ParameterDealUtil.parameterNullHandle(type);
        List<Integer> list = ParameterDealUtil.pageParameterDeal(page, limit);
        return setResultSuccess(activityTypeService.getActivityTypeList(type, Long.valueOf(list.get(0)), list.get(1)));
    }

    @RequestMapping("/all")
    public BaseResponse getActivityTypeAll() {
        return setResultSuccess(activityTypeService.getActivityTypeAll());
    }

    @PostMapping("/add")
    public BaseResponse addActivityType(@RequestBody ActivityType activityType) {
        activityTypeService.saveActivityType(activityType);
        return setResultSuccess();
    }

    @GetMapping("/modify/{id}")
    public BaseResponse modifyActivityType(@PathVariable("id") Integer id) {
        return setResultSuccess(activityTypeService.getActivityTypeOne(id));
    }

    @PostMapping("/update")
    public BaseResponse updateActivityType(@RequestBody ActivityType activityType) {
        activityTypeService.updateActivityTypeOne(activityType);
        return setResultSuccess();
    }

    @GetMapping("/deletes")
    public BaseResponse deleteActivityTypes(String idStr) {
        List<Integer> ids = ParameterDealUtil.stringSplitArray(idStr);
        if (null == ids) {
            return setResultError();
        }
        activityTypeService.deleteActivityTypes(ids);
        return setResultSuccess();
    }
}
