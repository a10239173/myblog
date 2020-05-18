package com.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {

    @GetMapping(value = "/admin")
    public String admin(){
        return "redirect:admin_user_list";
    }

    @GetMapping(value = "/admin_user_list")
    public String listUser(){
        return "admin/listUser";
    }

    @GetMapping(value = "/test")
    public String test(){
        return "admin/VueRouterTest";
    }

    @GetMapping(value = "/admin_role_list")
    public String listRole(){
        return "admin/listRole";
    }

    @GetMapping(value = "/edit_user")
    public String edit(){
        return "admin/editUser";
    }


}
