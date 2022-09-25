package com.detelin.kb.web.controller;

import com.detelin.kb.web.annotations.PageTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
@Controller
public class HomeController extends BaseController{
    @Autowired
    public HomeController() {
    }

    @GetMapping("/")
    @PreAuthorize("isAnonymous()")
    @PageTitle("Index")
    public ModelAndView index() {
        return super.view("index");
    }

    @GetMapping("/home")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("Home")
    public ModelAndView home(ModelAndView modelAndView, Principal principal) {
//        modelAndView.addObject("products",this.productService.findAll());
//        modelAndView.addObject("username",principal.getName());
        return super.view("home",modelAndView);
    }
}
