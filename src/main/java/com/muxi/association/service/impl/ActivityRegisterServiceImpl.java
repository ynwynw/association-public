package com.muxi.association.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.muxi.association.enums.ExamineStatusEnum;
import com.muxi.association.mapper.ActivityRegisterMapper;
import com.muxi.association.pojo.entity.ActivityRegister;
import com.muxi.association.pojo.entity.AssocMember;
import com.muxi.association.pojo.vo.ActivityRegisterVo;
import com.muxi.association.service.ActivityRegisterService;
import com.muxi.association.util.PagingDealUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ZXW
 */

@Service
public class ActivityRegisterServiceImpl implements ActivityRegisterService {

    @Resource
    private ActivityRegisterMapper activityRegisterMapper;

    @Override
    public Map<String, Object> getActivityRegisterList(String title, String status, Integer userId, Long pageNum, Integer limit) {
        List<ActivityRegisterVo> activityRegisterVo = activityRegisterMapper.selectAcRegisterVoListByCondition(title, ExamineStatusEnum.catchValue(status), userId,pageNum - 1, limit);
        Long total = activityRegisterMapper.selectAcRegisterVoCountByCondition(title, ExamineStatusEnum.catchValue(status), userId);
        return PagingDealUtil.pageReturnValueDeal(activityRegisterVo, total, limit);
    }

    @Override
    public void saveActivityRegister(ActivityRegister activityRegister) {
        activityRegisterMapper.insert(activityRegister);
    }

    @Override
    public ActivityRegister getActivityRegisterByUserIdActivityId(Integer userId, Integer activityId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (userId != null) {
            queryWrapper.eq("user_id", userId);
        }
        if (userId != null) {
            queryWrapper.eq("activity_id", activityId);
        }
        return activityRegisterMapper.selectOne(queryWrapper);
    }

    @Override
    public Integer getOneActivityRegisterPersonCount(Integer activityId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (activityId != null) {
            queryWrapper.eq("activity_id", activityId);
        }
        return activityRegisterMapper.selectCount(queryWrapper);
    }

    @Override
    public void updateExamineStatus(Integer id, String status) {
        ActivityRegister acRegister = activityRegisterMapper.selectById(id);
        if (ExamineStatusEnum.catchValue(status) == ExamineStatusEnum.REJECTED) {
            activityRegisterMapper.deleteById(id);
        }
        acRegister.setRegisterStatus(ExamineStatusEnum.catchValue(status));
        activityRegisterMapper.updateById(acRegister);
    }
}
