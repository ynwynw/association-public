package com.muxi.association.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.muxi.association.pojo.entity.Role;

import java.util.List;

/**
 * @author ZXW
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 获取权限组
     * @return
     */
    List<String> selectAuthorityGroup();
}
