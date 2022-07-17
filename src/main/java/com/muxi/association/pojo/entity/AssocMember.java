package com.muxi.association.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.muxi.association.enums.ExamineStatusEnum;
import lombok.Data;

/**
 * @author ZXW
 */
@Data
@TableName(value = "assoc_member")
public class AssocMember {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "department")
    private String department;

    @TableField(value = "status")
    private ExamineStatusEnum status;

    @TableField(value = "association_id")
    private Integer associationId;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "role_id")
    private Integer roleId;
}
