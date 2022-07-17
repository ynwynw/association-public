package com.muxi.association.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.muxi.association.enums.ExamineStatusEnum;
import lombok.Data;

/**
 * @author ZXW
 */
@Data
public class AssocMemberVo {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableId(value = "department")
    private String department;

    @TableId(value = "status")
    private ExamineStatusEnum status;

    /**
     * 社团名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "credit")
    private Double credit;

    @TableField(value = "authority")
    private String authority;

    @TableField(value = "role")
    private String role;
}
