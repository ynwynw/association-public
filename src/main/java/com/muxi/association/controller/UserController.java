package com.muxi.association.controller;

import com.muxi.association.pojo.entity.User;
import com.muxi.association.service.UserService;
import com.muxi.association.util.BaseApiService;
import com.muxi.association.util.BaseResponse;
import com.muxi.association.util.ParameterDealUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZXW
 */
@RestController
@RequestMapping("/api/back/user")
public class UserController extends BaseApiService {

    @Resource
    private UserService userService;

    @RequestMapping("/list")
    public BaseResponse getUserRoleList(String username, Double credit, String authority, Integer page, Integer limit) {
        System.out.println(credit);
        username = ParameterDealUtil.parameterNullHandle(username);
        authority = ParameterDealUtil.parameterNullHandle(authority);
        List<Integer> list = ParameterDealUtil.pageParameterDeal(page, limit);
        return setResultSuccess(userService.getUserRoleList(username, credit, authority, Long.valueOf(list.get(0)), list.get(1)));
    }

    @PostMapping("/add")
    public BaseResponse addUser(@RequestBody User user) {
        userService.saveUser(user);
        return setResultSuccess();
    }

    @GetMapping("/modify/{id}")
    public BaseResponse modifyUser(@PathVariable("id") Integer id) {
        return setResultSuccess(userService.getUserOne(id));
    }

    @PostMapping("/update")
    public BaseResponse updateUser(@RequestBody User user) {
        userService.updateUserOne(user);
        return setResultSuccess();
    }

    @PostMapping("/status")
    public BaseResponse userStatus(@RequestBody User user) {
        userService.updateUserStatus(user.getId(), user.getStatus());
        return setResultSuccess();
    }

    @PostMapping("/person/edit")
    public BaseResponse personEditUser(@RequestBody User user) {
        userService.updatePersonInformation(user);
        return setResultSuccess();
    }

    @GetMapping("/deletes")
    public BaseResponse deleteUsers(String idStr) {
        List<Integer> ids = ParameterDealUtil.stringSplitArray(idStr);
        if (null == ids) {
            return setResultError();
        }
        userService.deleteUsers(ids);
        return setResultSuccess();
    }
}
