package com.muxi.association.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author ZXW
 */

@Data
public class LabelType {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String type;
    private String synopsis;
}
