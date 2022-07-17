package com.muxi.association.controller;

import com.muxi.association.enums.ExamineStatusEnum;
import com.muxi.association.pojo.entity.Activity;
import com.muxi.association.service.ActivityService;
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
@RequestMapping("/api/back/activity/info")
public class ActivityController extends BaseApiService {

    @Resource
    private ActivityService activityService;

    @RequestMapping("/list")
    public BaseResponse getActivityList(String title, String status, String level, Integer page, Integer limit) {
        title = ParameterDealUtil.parameterNullHandle(title);
        status = ParameterDealUtil.parameterNullHandle(status);
        level = ParameterDealUtil.parameterNullHandle(level);
        List<Integer> list = ParameterDealUtil.pageParameterDeal(page, limit);
        return setResultSuccess(activityService.getActivityList(title, status, level, Long.valueOf(list.get(0)), list.get(1)));
    }

    @PostMapping("/add")
    public BaseResponse addActivity(@RequestBody Activity activity) {
        activity.setStatus(ExamineStatusEnum.UNDER_REVIEW);
        activity.setScore(4.0);
        activityService.saveActivity(activity);
        return setResultSuccess();
    }

    @GetMapping("/modify/{id}")
    public BaseResponse modifyActivityVo(@PathVariable("id") Integer id) {
        return setResultSuccess(activityService.getActivityVoOne(id));
    }

    @PostMapping("/update")
    public BaseResponse updateLabelType(@RequestBody Activity activity) {
        activityService.updateActivityOne(activity);
        return setResultSuccess();
    }

    @GetMapping("/deletes")
    public BaseResponse deleteActivities(String idStr) {
        List<Integer> ids = ParameterDealUtil.stringSplitArray(idStr);
        if (null == ids) {
            return setResultError();
        }
        activityService.deleteActivities(ids);
        return setResultSuccess();
    }
}
