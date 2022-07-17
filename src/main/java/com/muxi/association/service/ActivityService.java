package com.muxi.association.service;

import com.muxi.association.pojo.entity.Activity;
import com.muxi.association.pojo.vo.ActivityVo;

import java.util.List;
import java.util.Map;

/**
 * @author ZXW
 */
public interface ActivityService {

    /**
     * 获取活动列表
     * @param title
     * @param status
     * @param level
     * @param pageNum
     * @param limit
     * @return
     */
    Map<String, Object> getActivityList(String title, String status, String level, Long pageNum, Integer limit);

    /**
     * 添加活动
     * @param activity
     */
    void saveActivity(Activity activity);

    /**
     * 更新活动评分
     * @param id
     */
    void updateActivityScore(Integer id);

    /**
     * 获取ActivityVo对象
     * @param id
     * @return
     */
    ActivityVo getActivityVoOne(Integer id);

    /**
     *  根据id删除
     * @param ids
     */
    void deleteActivities(List<Integer> ids);

    /**
     *  更新活动
     * @param activity
     */
    void updateActivityOne(Activity activity);
}
