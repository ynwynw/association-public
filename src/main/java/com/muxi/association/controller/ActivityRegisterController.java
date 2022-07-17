package com.muxi.association.controller;

import com.muxi.association.enums.ExamineStatusEnum;
import com.muxi.association.pojo.entity.ActivityRegister;
import com.muxi.association.pojo.entity.User;
import com.muxi.association.service.ActivityRegisterService;
import com.muxi.association.util.BaseApiService;
import com.muxi.association.util.BaseResponse;
import com.muxi.association.util.DealDateFormatUtil;
import com.muxi.association.util.ParameterDealUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ZXW
 */

@RestController
@RequestMapping("/api/back/activity/register")
public class ActivityRegisterController extends BaseApiService {

    @Resource
    private ActivityRegisterService activityRegisterService;

    @RequestMapping("/list")
    public BaseResponse getActivityTypeList(String title, String registerStatus, Integer page, Integer limit) {
        title = ParameterDealUtil.parameterNullHandle(title);
        registerStatus = ParameterDealUtil.parameterNullHandle(registerStatus);
        List<Integer> list = ParameterDealUtil.pageParameterDeal(page, limit);
        return setResultSuccess(activityRegisterService.getActivityRegisterList(title, registerStatus, null, Long.valueOf(list.get(0)), list.get(1)));
    }

    @PostMapping("/add")
    public BaseResponse addActivity(Integer activityId, Integer signUpPerson, String registerStartTime, String registerEndTime, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user.getStatus() == 0) {
            return setResultSuccess("您账号被警用，无法报名活动");
        }
        // 判断是否重复报名
        ActivityRegister acRegister = activityRegisterService.getActivityRegisterByUserIdActivityId(user.getId(), activityId);
        if (acRegister == null) {
            long currentTime = System.currentTimeMillis();
            if (currentTime >= DealDateFormatUtil.dealDateToLong(registerStartTime) && currentTime <= DealDateFormatUtil.dealDateToLong(registerEndTime)) {
                Integer count = activityRegisterService.getOneActivityRegisterPersonCount(activityId);
                if (count >= signUpPerson) {
                    return setResultSuccess("当前活动报名人数已满");
                }
                ActivityRegister activityRegister = new ActivityRegister();
                activityRegister.setActivityId(activityId);
                activityRegister.setRegisterStatus(ExamineStatusEnum.UNDER_REVIEW);
                activityRegister.setUserId(user.getId());
                activityRegisterService.saveActivityRegister(activityRegister);
                return setResultSuccess("报名成功");
            }
            return setResultSuccess("报名时间已过");
        } else if (acRegister.getRegisterStatus() == ExamineStatusEnum.UNDER_REVIEW) {
            return setResultSuccess("您已经申请,请等待审核");
        } else {
            return setResultSuccess("您已经加入活动,无需重复申请");
        }
    }

    @PostMapping("/examine")
    public BaseResponse dealExamine(Integer id, String status) {
        activityRegisterService.updateExamineStatus(id, status);
        return setResultSuccess();
    }

    @RequestMapping("/my")
    public BaseResponse dealMyActivity(String title, Integer page, Integer limit, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        title = ParameterDealUtil.parameterNullHandle(title);
        List<Integer> list = ParameterDealUtil.pageParameterDeal(page, limit);
        return setResultSuccess(activityRegisterService.getActivityRegisterList(title, "审核通过", user.getId(), Long.valueOf(list.get(0)), list.get(1)));
    }
}
