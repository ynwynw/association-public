package com.muxi.association.controller;

import com.muxi.association.pojo.entity.Score;
import com.muxi.association.pojo.entity.User;
import com.muxi.association.service.ActivityService;
import com.muxi.association.service.ScoreService;
import com.muxi.association.util.BaseApiService;
import com.muxi.association.util.BaseResponse;
import com.muxi.association.util.ParameterDealUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ZXW
 */
@RestController
@RequestMapping("/api/back/activity/score")
public class ScoreController extends BaseApiService {

    @Resource
    private ScoreService scoreService;

    @Resource
    private ActivityService activityService;

    @RequestMapping("/list")
    public BaseResponse getScoreVoList(String title, String level, Integer page, Integer limit) {
        title = ParameterDealUtil.parameterNullHandle(title);
        level = ParameterDealUtil.parameterNullHandle(level);
        List<Integer> list = ParameterDealUtil.pageParameterDeal(page, limit);
        return setResultSuccess(scoreService.getScoreVoList(title, level, Long.valueOf(list.get(0)), list.get(1)));
    }

    @PostMapping("/add")
    public BaseResponse addScore(@RequestBody Score score, HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        List<Score> scoreList = scoreService.getScoresByCondition(user.getId(), score.getActivityId());
        if (scoreList.size() == 0) {
            score.setUserId(user.getId());
            scoreService.saveScore(score);
            activityService.updateActivityScore(score.getActivityId());
            return setResultSuccess("评论已经完成");
        }
        return setResultSuccess("您已经评论过了, 不能重复评论");
    }

    @GetMapping("/modify/{userId}/{activityId}")
    public BaseResponse modifyScore(@PathVariable("userId") Integer userId, @PathVariable("activityId") Integer activityId) {
        return setResultSuccess(scoreService.getScoresByCondition(userId, activityId));
    }

    @GetMapping("/delete/{userId}/{activityId}")
    public BaseResponse deleteScore(@PathVariable("userId") Integer userId, @PathVariable("activityId") Integer activityId) {
        if (userId != null && activityId != null) {
            scoreService.deleteScore(userId, activityId);
        }
        return setResultSuccess();
    }
}
