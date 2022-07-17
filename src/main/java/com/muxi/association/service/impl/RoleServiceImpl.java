package com.muxi.association.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muxi.association.mapper.RoleMapper;
import com.muxi.association.pojo.entity.Organization;
import com.muxi.association.pojo.entity.Role;
import com.muxi.association.service.RoleService;
import com.muxi.association.util.PagingDealUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZXW
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Map<String, Object> getRoleList(String authority, String role, Long pageNum, Integer limit) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (authority != null) {
            queryWrapper.eq("authority", authority);
        }
        if (role != null) {
            queryWrapper.like("role", role);
        }
        Page<Role> page = new Page<>(pageNum, limit);
        return PagingDealUtil.pageReturnValueDeal(roleMapper, page, queryWrapper);
    }

    @Override
    public Map<String, Object> getRoleOption() {
        List<String> list = roleMapper.selectAuthorityGroup();
        Map<String, Object> map = new HashMap<>(10);
        QueryWrapper queryWrapper;
        for(int i = 0; i < list.size(); i ++){
            queryWrapper = new QueryWrapper();
            queryWrapper.eq("authority", list.get(i));
            map.put(list.get(i), roleMapper.selectList(queryWrapper));
        }
        return map;
    }

    @Override
    public void saveRole(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public Role getRoleOne(Integer id) {
        return roleMapper.selectById(id);
    }

    @Override
    public Role getRoleOne(String role) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (role != null) {
            queryWrapper.like("role", role);
        }
        return roleMapper.selectOne(queryWrapper);
    }

    @Override
    public Role getRoleByRole(String role) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (role != null) {
            queryWrapper.eq("role", role);
        }
        return roleMapper.selectOne(queryWrapper);
    }

    @Override
    public void updateRoleOne(Role role) {
        roleMapper.updateById(role);
    }

    @Override
    public void deleteRoles(List<Integer> ids) {
        roleMapper.deleteBatchIds(ids);
    }
}
