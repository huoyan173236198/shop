package com.cn.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cn.BackUser;
import com.cn.IBackUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version 1.0
 * @user 灬焰
 * @date 2019/12/1 20:51
 */
@Controller
public class LoginController {

    @Reference
    private IBackUserService backUserService;

    //声明一个日志记录器对象
    public static final Logger log = LoggerFactory.getLogger(LoginController.class.getName());
    /**
     * 跳转到登录页面
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        log.info("用户已经来到登录页面");
        log.debug("111111");
        log.warn("用户已经来到登录页面---warn");
        System.out.println("用户已经来到登录页面 +++++++++++++");
        return "login";
    }

    /**进行登录*/
    @RequestMapping("/login")
    public String login(String username,String password , Model model) {
        log.info("用户的姓名："+username+"-------用户的密码："+password);
        BackUser backUser = backUserService.login(username, password);
        if (backUser != null) {
            model.addAttribute("loginUser",backUser);
            log.info("用户登录状态：Successful");
            return "index2";
        }
        log.info("用户登录状态：Faile");
        return "redirect:/toLogin?error=1";
    }
}
