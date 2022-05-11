package com.shuai.sys.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.shuai.sys.constant.SysConstant;
import com.shuai.sys.domain.User;
import com.shuai.sys.service.UserService;
import com.shuai.sys.utils.WebUtils;
import com.shuai.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("login")
public class LonginController {

    @Autowired
    private UserService userService;

    @RequestMapping("toLogin")
    public String toLogin(){
        return "system/main/login";
    }

    @RequestMapping("getCode")
    public void getCode(HttpServletResponse response, HttpSession session) throws IOException {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 36, 4, 5);
        session.setAttribute("code",lineCaptcha.getCode());
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(lineCaptcha.getImage(),"JPEG",outputStream);
    }

    @RequestMapping("login")
    public String login(UserVo userVo, Model model){
        String code = WebUtils.getHttpSession().getAttribute("code").toString();
        if (userVo.getCode().equals(code)) {
            User user = userService.login(userVo);
            if (user != null) {
                WebUtils.getHttpSession().setAttribute("user",user);
                return "system/main/index";
            }else {
                model.addAttribute("error", SysConstant.USER_LOGIN_ERROR_MSG);
                return "system/main/login";
            }
        }else {
            model.addAttribute("error",SysConstant.USER_LOGIN_CODE_ERROR_MSG);
            return "system/main/login";
        }
    }
}
