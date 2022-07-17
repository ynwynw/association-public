package com.muxi.association.pojo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
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
public class Activity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "title")
    private String title;

    @TableField(value = "synopsis")
    private String synopsis;

    @TableField(value = "level")
    private ActivityLevelEnum level;

    @TableField(value = "is_leave")
    private Boolean isLeave;

    @TableField(value = "status")
    private ExamineStatusEnum status;

    @TableField(value = "sign_up_person")
    private Integer signUpPerson;

    @TableField(value = "credit")
    private Double credit;

    @TableField(value = "score")
    private Double score;

    @TableField(value = "register_start_time")
    private Timestamp registerStartTime;

    @TableField(value = "register_end_time")
    private Timestamp registerEndTime;

    @TableField(value = "activity_start_time")
    private Timestamp activityStartTime;

    @TableField(value = "activity_end_time")
    private Timestamp activityEndTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Timestamp createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;

    @TableField(value = "activity_type_id")
    private String activityTypeId;

    @TableField(value = "label_type_id")
    private String labelTypeId;

    @TableField(value = "organization_id")
    private String organizationId;

    @TableField(value = "association_id")
    private String associationId;
}
