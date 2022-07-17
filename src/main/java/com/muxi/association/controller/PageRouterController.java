package com.muxi.association.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZXW
 */
@Controller
@RequestMapping("/back")
public class PageRouterController {

    @GetMapping("/login")
    public String login() {
        return "system/login";
    }

    @GetMapping("/register")
    public String register() { return "system/register"; }

    @GetMapping("/index")
    public String index() {
        return "index";
    }


    @GetMapping("/welcome")
    public String welcome() {
        return  "welcome";
    }

    @GetMapping("/welcome/new/china")
    public String newChinaHistory() {
        return "fourHistories/newChina";
    }

    @GetMapping("/welcome/party")
    public String partyHistory() {
        return "fourHistories/party";
    }

    @GetMapping("/welcome/reform")
    public String reformHistory() {
        return "fourHistories/reform";
    }

    @GetMapping("/welcome/socialist")
    public String socialistHistory() {
        return "fourHistories/socialist";
    }


    @GetMapping("/label/type/list")
    public String labelTypeList() {
        return "typeManagement/label/labelList";
    }

    @GetMapping("/label/type/add")
    public String labelTypeAdd() {
        return "typeManagement/label/labelAdd";
    }

    @GetMapping("/label/type/edit")
    public String labelTypeEdit() {
        return "typeManagement/label/labelEdit";
    }

    @GetMapping("/organize/list")
    public String organizationList() {
        return "typeManagement/organization/organizationList";
    }

    @GetMapping("/organize/add")
    public String organizationAdd() {
        return "typeManagement/organization/organizationAdd";
    }

    @GetMapping("/organize/edit")
    public String organizationEdit() {
        return "typeManagement/organization/organizationEdit";
    }


    @GetMapping("/user/list")
    public String userList() {
        return "userManagement/user/userList";
    }

    @GetMapping("/user/add")
    public String userAdd() {
        return "userManagement/user/userAdd";
    }

    @GetMapping("/user/edit")
    public String userEdit() {
        return "userManagement/user/userEdit";
    }

    @GetMapping("/role/list")
    public String roleList() {
        return "userManagement/role/roleList";
    }

    @GetMapping("/role/add")
    public String roleAdd() {
        return "userManagement/role/roleAdd";
    }

    @GetMapping("/role/edit")
    public String roleEdit() {
        return "userManagement/role/roleEdit";
    }


    @GetMapping("/person/edit")
    public String personEdit() {
        return "personManagement/personalData";
    }

    @GetMapping("/person/activity")
    public String personActivity() {
        return "personManagement/personalActivity";
    }

    @GetMapping("/person/comment")
    public String personComment() {
        return "personManagement/personalAcComment";
    }

    @GetMapping("/person/watch/comment")
    public String personWatComment() {
        return "personManagement/personAcWatComment";
    }


    @GetMapping("/activity/square/list")
    public String activitySquareList() {
        return "activitySquare/activitySquareList";
    }

    @GetMapping("/activity/square/detail")
    public String activitySquareDetail() {
        return "activitySquare/activitySquareDetail";
    }

    @GetMapping("/activity/info/list")
    public String activityInfoList() {
        return "activityManagement/activity/activityList";
    }

    @GetMapping("/activity/info/detail")
    public String activityInfoDetail() {
        return "activityManagement/activity/activityDetail";
    }

    @GetMapping("/activity/info/add")
    public String activityInfoAdd() {
        return "activityManagement/activity/activityAdd";
    }

    @GetMapping("/activity/type/list")
    public String activityTypeList() {
        return "activityManagement/type/acTypeList";
    }

    @GetMapping("/activity/type/add")
    public String activityTypeAdd() {
        return "activityManagement/type/acTypeAdd";
    }

    @GetMapping("/activity/type/edit")
    public String activityTypeEdit() {
        return "activityManagement/type/acTypeEdit";
    }

    @GetMapping("/activity/examine/list")
    public String activityExamineList() {
        return "activityManagement/activityExamine/acExamineList";
    }

    @GetMapping("/activity/examine/detail")
    public String activityExamineDetail() {
        return "activityManagement/activityExamine/acExamineDetail";
    }

    @GetMapping("/activity/register/examine/list")
    public String activityRegisterExamineList() {
        return "activityManagement/activityRegister/acReExamineList";
    }

    @GetMapping("/activity/comment/list")
    public String activityCommentList() {
        return "activityManagement/activityComment/acCommentList";
    }


    @GetMapping("/association/square/list")
    public String associationSquareList() {
        return "associationSquare/associationSquareList";
    }

    @GetMapping("/association/square/detail")
    public String associationSquareDetail() {
        return "associationSquare/associationSquareDetail";
    }

    @GetMapping("/association/info/list")
    public String associationInfoList() {
        return "associationManagement/association/associationList";
    }

    @GetMapping("/association/info/add")
    public String associationInfoAdd() {
        return "associationManagement/association/associationAdd";
    }

    @GetMapping("/association/info/edit")
    public String associationInfoEdit() {
        return "associationManagement/association/associationEdit";
    }

    @GetMapping("/member/info/list")
    public String memberInfoList() {
        return "associationManagement/member/memberList";
    }

    @GetMapping("/member/info/edit")
    public String memberInfoEdit() {
        return "associationManagement/member/memberEdit";
    }

    @GetMapping("/member/examine/list")
    public String memberExamineList() {
        return "associationManagement/memberExamine/mbExamineList";
    }

}
