package com.detelin.kb.web.controller;

import com.detelin.kb.services.RoleService;
import com.detelin.kb.services.UserService;
import com.detelin.kb.web.annotations.PageTitle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(name = "/users")
public class UserController extends BaseController{
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper, RoleService roleService){
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
    }
    @GetMapping("/register")
    @PreAuthorize("isAnonymous()")
    @PageTitle("Index")
    public ModelAndView register() {
        return super.view("userLists");
    }
    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    @PageTitle("Index")
    public ModelAndView registerConfirm(){
        return super.view("userLists");
    }

    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    @PageTitle("Index")
    public ModelAndView login() {
        return super.view("userLists");
    }


}
