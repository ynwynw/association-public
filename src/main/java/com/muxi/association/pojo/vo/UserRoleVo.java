package com.muxi.association.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author ZXW
 */

@Data
public class UserRoleVo {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "username")
    private String username;

    @TableField(value = "password")
    private String password;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "status")
    private Integer status;

    @TableField(value = "credit")
    private Double credit;

    @TableField(value = "create_time")
    private Timestamp createTime;

    @TableField(value = "update_time")
    private Timestamp updateTime;

    @TableField(value = "authority")
    private String authority;

    @TableField(value = "role")
    private String role;

    @TableField(value = "roleId")
    private Integer roleId;
}
