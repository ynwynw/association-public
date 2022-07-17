package com.muxi.association.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author ZXW
 */
@Data
public class ActivityType {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "type")
    private String type;

    @TableField(value = "synopsis")
    private String synopsis;
}
