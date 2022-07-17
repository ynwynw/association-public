package com.muxi.association.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.muxi.association.config.KaptchaConfig;
import com.muxi.association.pojo.entity.Role;
import com.muxi.association.pojo.entity.User;
import com.muxi.association.service.RoleService;
import com.muxi.association.service.SystemService;
import com.muxi.association.util.BaseApiService;
import com.muxi.association.util.BaseResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author ZXW
 */
@RestController
@RequestMapping("/api/back")
public class SystemController extends BaseApiService {

    @Resource
    private SystemService systemService;

    @Resource
    private RoleService roleService;

    @Resource
    private DefaultKaptcha defaultKaptcha;

    @PostMapping("/login/{phone}/{password}/{verCode}")
    public BaseResponse backLogin(@PathVariable("phone") String phone, @PathVariable("password") String password, @PathVariable("verCode") String verCode, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String verCodeSession = (String) session.getAttribute("verCode");
//        if (!verCodeSession.equalsIgnoreCase(verCode)) {
//            return setResultNoAuthority();
//        }
        User user = systemService.backLogin(phone, password);
        if (user != null) {
            Role role = roleService.getRoleOne(user.getRoleId());
            session.setAttribute("user", user);
            session.setAttribute("role", role);
            return setResultSuccess();
        }
        return setResultError();
    }

    @PostMapping("/register")
    public BaseResponse backRegister(@RequestBody User user) {
        if (systemService.getUserByPhone(user.getPhone()) != null) {
            return setResultError();
        }
        user.setCredit(0D);
        user.setStatus(1);
        user.setRoleId(roleService.getRoleOne("学生").getId());
        systemService.register(user);
        return setResultSuccess();
    }

    @GetMapping("/login/out")
    public BaseResponse backLoginOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("role");
        return setResultSuccess();
    }

    @GetMapping("/login/verCode")
    public void loginVerCode(HttpSession session, HttpServletResponse response) throws IOException {
        byte[] captchaChallengeAsJpeg;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            // 生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            session.setAttribute("verCode", createText);
            // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    @GetMapping("/system/user")
    public BaseResponse backGetUser(HttpServletRequest request) {
        return setResultSuccess(request.getSession().getAttribute("user"));
    }

    @GetMapping("/system/role")
    public BaseResponse backGetRole(HttpServletRequest request) {
        return setResultSuccess(request.getSession().getAttribute("role"));
    }
}
