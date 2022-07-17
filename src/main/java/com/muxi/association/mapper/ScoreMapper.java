package com.muxi.association.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.muxi.association.enums.ActivityLevelEnum;
import com.muxi.association.pojo.entity.Score;
import com.muxi.association.pojo.vo.ScoreVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZXW
 */
public interface ScoreMapper extends BaseMapper<Score> {

    /**
     * 根据条件获取对象
     * @param title
     * @param level
     * @param pageNum
     * @param limit
     * @return
     */
    List<ScoreVo> selectScoreVoListByCondition(@Param("title") String title, @Param("level") ActivityLevelEnum level, @Param("pageNum") Long pageNum, @Param("limit") Integer limit);

    /**
     * 根据条件获取对象
     * @param title
     * @param level
     * @return
     */
    Long selectScoreVoByCountCondition(@Param("title") String title, @Param("level") ActivityLevelEnum level);
}
