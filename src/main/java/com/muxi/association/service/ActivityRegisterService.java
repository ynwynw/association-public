package com.muxi.association.service;

import com.muxi.association.pojo.entity.ActivityRegister;

import java.util.Map;

/**
 * @author ZXW
 */
public interface ActivityRegisterService {

    /**
     * 获取活动表名对象列表
     * @param title
     * @param status
     * @param userId
     * @param pageNum
     * @param limit
     * @return
     */
    Map<String, Object> getActivityRegisterList(String title, String status, Integer userId, Long pageNum, Integer limit);

    /**
     * 报存报名对象
     * @param activityRegister
     */
    void saveActivityRegister(ActivityRegister activityRegister);

    /**
     * 通过userid和活动id获取用户
     * @param userId
     * @param activityId
     * @return
     */
    ActivityRegister getActivityRegisterByUserIdActivityId(Integer userId, Integer activityId);

    /**
     * 获取单个活动总共报名人数
     * @param activityId
     * @return
     */
    Integer getOneActivityRegisterPersonCount(Integer activityId);

    /**
     * 更新报名审核状态
     * @param id
     * @param status
     */
    void updateExamineStatus(Integer id, String status);
}
