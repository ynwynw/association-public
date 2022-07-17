package com.muxi.association.service;

import com.muxi.association.pojo.entity.Score;

import java.util.List;
import java.util.Map;

/**
 * @author ZXW
 */
public interface ScoreService {

    /**
     * 根据条件获取评分Score对象
     * @param activityId
     * @return
     */
    List<Score> getScoreList(Integer activityId);

    /**
     * 条件获取ScoreVo对象
     * @param title
     * @param level
     * @param page
     * @param limit
     * @return
     */
    Map<String, Object> getScoreVoList(String title, String level, Long page, Integer limit);

    /**
     * 根据条件获取Score对象集合
     * @param userId
     * @param activityId
     * @return
     */
    List<Score> getScoresByCondition(Integer userId, Integer activityId);

    /**
     * 添加评论
     * @param score
     */
    void saveScore(Score score);

    /**
     * 删除评论
     * @param userId
     * @param activityId
     */
    void deleteScore(Integer userId, Integer activityId);
}
