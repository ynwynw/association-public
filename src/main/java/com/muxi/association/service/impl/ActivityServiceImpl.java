package com.muxi.association.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muxi.association.enums.ActivityLevelEnum;
import com.muxi.association.enums.ExamineStatusEnum;
import com.muxi.association.mapper.*;
import com.muxi.association.pojo.entity.Activity;
import com.muxi.association.pojo.entity.Organization;
import com.muxi.association.pojo.entity.Score;
import com.muxi.association.pojo.vo.ActivityVo;
import com.muxi.association.service.ActivityService;
import com.muxi.association.service.ScoreService;
import com.muxi.association.util.PagingDealUtil;
import com.muxi.association.util.ParameterDealUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ZXW
 */

@Service
public class ActivityServiceImpl implements ActivityService {

    @Resource
    private ActivityMapper activityMapper;

    @Resource
    private ActivityTypeMapper activityTypeMapper;

    @Resource
    private LabelTypeMapper labelTypeMapper;

    @Resource
    private OrganizationMapper organizationMapper;

    @Resource
    private AssociationMapper associationMapper;

    @Resource
    private ScoreService scoreService;

    @Override
    public Map<String, Object> getActivityList(String title, String status, String level, Long pageNum, Integer limit) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (title != null) {
            queryWrapper.like("title", title);
        }
        if (status != null) {
            queryWrapper.eq("status", ExamineStatusEnum.catchValue(status));
        }
        if (level != null) {
            queryWrapper.eq("level", ActivityLevelEnum.catchValue(level));
        }
        queryWrapper.orderByDesc("id");
        Page<Activity> page = new Page<>(pageNum, limit);
        return PagingDealUtil.pageReturnValueDeal(activityMapper, page, queryWrapper);
    }

    @Override
    public void saveActivity(Activity activity) {
        activityMapper.insert(activity);
    }

    @Override
    public void updateActivityScore(Integer id) {
        List<Score> scoreList = scoreService.getScoreList(id);
        Activity activity = activityMapper.selectById(id);
        if (scoreList.size() == 0) {
            activity.setScore(4.0);
        } else {
            double sum = 0;
            for (Score s : scoreList) {
                sum += s.getGrade();
            }
            activity.setScore(sum/scoreList.size());
        }
        updateActivityOne(activity);
    }

    @Override
    public ActivityVo getActivityVoOne(Integer id) {
        Activity activity = activityMapper.selectById(id);
        ActivityVo activityVo = new ActivityVo(activity);
        List<Integer> acList = ParameterDealUtil.stringSplitToArray(activity.getActivityTypeId());
        List<Integer> labelList = ParameterDealUtil.stringSplitToArray(activity.getLabelTypeId());
        List<Integer> organList = ParameterDealUtil.stringSplitToArray(activity.getOrganizationId());
        List<Integer> associationId = ParameterDealUtil.stringSplitToArray(activity.getAssociationId());
        if (acList.size() != 0) {
            activityVo.setActivityTypeList(activityTypeMapper.selectBatchIds(acList));
        } else {
            activityVo.setActivityTypeList(new ArrayList<>());
        }
        if (acList.size() != 0) {
            activityVo.setLabelTypeList(labelTypeMapper.selectBatchIds(labelList));
        } else {
            // 前端需要数组集合 查询没有 自己创建集合给前端
            activityVo.setLabelTypeList(new ArrayList<>());
        }
        if (organList.size() != 0) {
            activityVo.setOrganizationList(organizationMapper.selectBatchIds(organList));
        } else {
            activityVo.setOrganizationList(new ArrayList<>());
        }
        if (associationId.size() != 0) {
            activityVo.setAssociationList(associationMapper.selectBatchIds(associationId));
        } else {
            activityVo.setAssociationList(new ArrayList<>());
        }
        return activityVo;
    }

    @Override
    public void deleteActivities(List<Integer> ids) {
        activityMapper.deleteBatchIds(ids);
    }

    @Override
    public void updateActivityOne(Activity activity) {
        activityMapper.updateById(activity);
    }

}
