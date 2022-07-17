package com.muxi.association.service;

import com.muxi.association.pojo.entity.ActivityType;
import com.muxi.association.pojo.entity.LabelType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ZXW
 */
@Service
public interface ActivityTypeService {

    /**
     * 根据条件获取标签列表
     * @param type
     * @param pageNum
     * @param limit
     * @return
     */
    Map<String, Object> getActivityTypeList(String type, Long pageNum, Integer limit);

    /**
     * 获得所有活动类型
     * @return
     */
    List<ActivityType> getActivityTypeAll();

    /**
     * 报存标签类型
     * @param activityType
     */
    void saveActivityType(ActivityType activityType);

    /**
     * 通过id获取对象
     * @param id
     * @return
     */
    ActivityType getActivityTypeOne(Integer id);

    /**
     * 更新label对象
     * @param activityType
     */
    void updateActivityTypeOne(ActivityType activityType);

    /**
     *  根据id删出
     * @param ids
     */
    void deleteActivityTypes(List<Integer> ids);
}
