package com.muxi.association.service.impl;

import com.muxi.association.mapper.UserMapper;
import com.muxi.association.pojo.entity.User;
import com.muxi.association.pojo.vo.UserRoleVo;
import com.muxi.association.service.UserService;
import com.muxi.association.util.PagingDealUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ZXW
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Map<String, Object> getUserRoleList(String username, Double credit, String authority, Long pageNum, Integer limit) {
        List<UserRoleVo> userRoleVoList = userMapper.selectUserRoleListByCondition(username, credit, authority, pageNum-1, limit);
        Long total = userMapper.selectUserRoleCountByCondition(username, credit, authority);
        return PagingDealUtil.pageReturnValueDeal(userRoleVoList, total, limit);
    }

    @Override
    public void saveUser(User user) {
        user.setStatus(1);
        userMapper.insert(user);
    }

    @Override
    public User getUserOne(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public void updateUserOne(User user) {
        userMapper.updateById(user);
    }

    @Override
    public void updateUserStatus(Integer id, Integer status) {
        User user = getUserOne(id);
        user.setStatus(status);
        updateUserOne(user);
    }

    @Override
    public void updatePersonInformation(User user) {
        User userGoal = getUserOne(user.getId());
        userGoal.setUsername(user.getUsername());
        userGoal.setPassword(user.getPassword());
        updateUserOne(userGoal);
    }

    @Override
    public void deleteUsers(List<Integer> ids) {
        userMapper.deleteBatchIds(ids);
    }
}
