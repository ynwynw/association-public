package com.muxi.association.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.muxi.association.enums.ActivityLevelEnum;
import com.muxi.association.mapper.ScoreMapper;
import com.muxi.association.pojo.entity.Score;
import com.muxi.association.pojo.vo.ScoreVo;
import com.muxi.association.service.ScoreService;
import com.muxi.association.util.PagingDealUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ZXW
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Resource
    private ScoreMapper scoreMapper;

    @Override
    public List<Score> getScoreList(Integer activityId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (activityId != null) {
            queryWrapper.eq("activity_id", activityId);
        }
        return scoreMapper.selectList(queryWrapper);
    }

    @Override
    public Map<String, Object> getScoreVoList(String title, String level, Long pageNum, Integer limit) {
        List<ScoreVo> scoreVos = scoreMapper.selectScoreVoListByCondition(title, ActivityLevelEnum.catchValue(level), pageNum - 1, limit);
        Long total = scoreMapper.selectScoreVoByCountCondition(title, ActivityLevelEnum.catchValue(level));
        return PagingDealUtil.pageReturnValueDeal(scoreVos, total, limit);
    }

    @Override
    public List<Score> getScoresByCondition(Integer userId, Integer activityId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (userId != null) {
            queryWrapper.eq("user_id", userId);
        }
        if (userId != null) {
            queryWrapper.eq("activity_id", activityId);
        }
        return scoreMapper.selectList(queryWrapper);
    }

    @Override
    public void saveScore(Score score) {
        scoreMapper.insert(score);
    }

    @Override
    public void deleteScore(Integer userId, Integer activityId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (userId != null) {
            queryWrapper.eq("user_id", userId);
        }
        if (userId != null) {
            queryWrapper.eq("activity_id", activityId);
        }
        scoreMapper.delete(queryWrapper);
    }
}
