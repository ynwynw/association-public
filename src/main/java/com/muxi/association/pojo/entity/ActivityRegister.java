package com.muxi.association.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.muxi.association.enums.ExamineStatusEnum;
import lombok.Data;

/**
 * @author ZXW
 */
@Data
public class ActivityRegister {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "activity_id")
    private Integer activityId;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "register_status")
    private ExamineStatusEnum registerStatus;
}
