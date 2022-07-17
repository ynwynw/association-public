package com.muxi.association.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muxi.association.mapper.ActivityTypeMapper;
import com.muxi.association.pojo.entity.ActivityType;
import com.muxi.association.service.ActivityTypeService;
import com.muxi.association.util.PagingDealUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ZXW
 */
@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    @Resource
    private ActivityTypeMapper activityTypeMapper;

    @Override
    public Map<String, Object> getActivityTypeList(String type, Long pageNum, Integer limit) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (type != null) {
            queryWrapper.like("type", type);
        }
        Page<ActivityType> page = new Page<>(pageNum, limit);
        return PagingDealUtil.pageReturnValueDeal(activityTypeMapper, page, queryWrapper);
    }

    @Override
    public List<ActivityType> getActivityTypeAll() {
        return activityTypeMapper.selectList(new QueryWrapper());
    }

    @Override
    public void saveActivityType(ActivityType activityType) {
        activityTypeMapper.insert(activityType);
    }

    @Override
    public ActivityType getActivityTypeOne(Integer id) {
        return activityTypeMapper.selectById(id);
    }

    @Override
    public void updateActivityTypeOne(ActivityType activityType) {
        activityTypeMapper.updateById(activityType);
    }

    @Override
    public void deleteActivityTypes(List<Integer> ids) {
        activityTypeMapper.deleteBatchIds(ids);
    }
}
