package com.muxi.association.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.muxi.association.enums.ExamineStatusEnum;
import com.muxi.association.pojo.entity.ActivityRegister;
import com.muxi.association.pojo.vo.ActivityRegisterVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZXW
 */
public interface ActivityRegisterMapper extends BaseMapper<ActivityRegister> {

    /**
     * 根据条件获取列表
     * @param title
     * @param registerStatus
     * @param userId
     * @param pageNum
     * @param limit
     * @return
     */
    List<ActivityRegisterVo> selectAcRegisterVoListByCondition(@Param("title") String title, @Param("registerStatus")ExamineStatusEnum registerStatus, @Param("userId") Integer userId, @Param("pageNum") Long pageNum, @Param("limit") Integer limit);

    /**
     * 根据条件获取个数
     * @param title
     * @param registerStatus
     * @param userId
     * @return
     */
    Long selectAcRegisterVoCountByCondition(@Param("title") String title, @Param("registerStatus")ExamineStatusEnum registerStatus, @Param("userId") Integer userId);
}
