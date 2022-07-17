package com.muxi.association.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.muxi.association.enums.ActivityLevelEnum;
import com.muxi.association.enums.ExamineStatusEnum;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author ZXW
 */
@Data
public class ActivityRegisterVo {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "activity_id")
    private Integer activityId;

    @TableField(value = "title")
    private String title;

    @TableField(value = "activity_start_time")
    private Timestamp activityStartTime;

    @TableField(value = "activity_end_time")
    private Timestamp activityEndTime;

    @TableField(value = "level")
    private ActivityLevelEnum level;

    /**
     * 用户学分
     */
    @TableField(value = "credit")
    private Double credit;

    /**
     * 活动学分
     */
    @TableField(value = "ac_credit")
    private Double acCredit;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "username")
    private String username;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "register_status")
    private ExamineStatusEnum registerStatus;
}
