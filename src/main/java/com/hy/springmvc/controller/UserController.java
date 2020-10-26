package com.hy.springmvc.controller;

import com.hy.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @PostMapping(value = "/login")
    public String login(User user, Model model, HttpSession session){
        String username=user.getUsername();
        String password=user.getPassword();
        System.out.println(username+"==========="+password);
        //些处横板从数据库中获取对用户名和密码后进行判断
        if(username!=null&&username.equals("admin")&&password!=null&&password.equals("admin")){
            //将用户对象添加到Session中
            session.setAttribute("USER_SESSION",user);
            return "redirect:/main.do";
        }
        model.addAttribute("msg","用户名或密码错误，请重新登录！");
        //return "/login.do";
        return "/view/login.jsp";
    }

    @RequestMapping(value = "/main")
    public String toMain(){
        return "/view/main.jsp";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        //session.invalidate();
        session.removeAttribute("USER_SESSION");
        return "redirect:/view/login.jsp";
    }

}
