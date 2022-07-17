package com.muxi.association.service;

import com.muxi.association.pojo.entity.User;

/**
 * @author ZXW
 */
public interface SystemService {

    /**
     * 登录业务处理
     * @param phone
     * @param password
     * @return
     */
    User backLogin(String phone, String password);

    /**
     * 注册
     * @param user
     */
    void register(User user);

    /**
     * 根据电话号码查询用户
     * @param phone
     * @return
     */
    User getUserByPhone(String phone);
}
