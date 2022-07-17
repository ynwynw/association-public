package com.muxi.association.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author ZXW
 */
@Data
public class Score {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "activity_id")
    private Integer activityId;

    @TableField(value = "grade")
    private Double grade;

    @TableField(value = "comment")
    private String comment;
}
