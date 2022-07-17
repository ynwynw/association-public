package com.muxi.association.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.muxi.association.pojo.entity.User;
import com.muxi.association.mapper.UserMapper;
import com.muxi.association.service.SystemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZXW
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User backLogin(String phone, String password) {
        User user = getUserByPhone(phone);
        return user != null && password.equals(user.getPassword()) ? user : null;
    }

    @Override
    public void register(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getUserByPhone(String phone) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (phone != null) {
            queryWrapper.eq("phone", phone);
        }
        return userMapper.selectOne(queryWrapper);
    }
}
