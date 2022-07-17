package com.muxi.association.pojo.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.muxi.association.enums.ActivityLevelEnum;
import com.muxi.association.enums.ExamineStatusEnum;
import com.muxi.association.pojo.entity.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author ZXW
 */
@Data
public class ActivityVo {
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

    private List<ActivityType> activityTypeList;

    private List<LabelType> labelTypeList;

    private List<Organization> organizationList;

    private List<Association> associationList;

    public ActivityVo() {
    }

    public ActivityVo(Activity activity) {
        this.id = activity.getId();
        this.title = activity.getTitle();
        this.synopsis = activity.getSynopsis();
        this.level = activity.getLevel();
        this.isLeave = activity.getIsLeave();
        this.status = activity.getStatus();
        this.signUpPerson = activity.getSignUpPerson();
        this.credit = activity.getCredit();
        this.score = activity.getScore();
        this.registerStartTime = activity.getRegisterStartTime();
        this.registerEndTime = activity.getRegisterEndTime();
        this.activityStartTime = activity.getActivityStartTime();
        this.activityEndTime = activity.getActivityEndTime();
        this.createTime = activity.getCreateTime();
        this.updateTime = activity.getUpdateTime();
    }
}
