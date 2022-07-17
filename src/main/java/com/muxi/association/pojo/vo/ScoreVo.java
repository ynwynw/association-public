package com.muxi.association.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.muxi.association.enums.ActivityLevelEnum;
import lombok.Data;

/**
 * @author ZXW
 */

@Data
public class ScoreVo {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "username")
    private String username;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "title")
    private String title;

    @TableField(value = "level")
    private ActivityLevelEnum level;

    @TableField(value = "grade")
    private Double grade;

    @TableField(value = "comment")
    private String comment;
}
