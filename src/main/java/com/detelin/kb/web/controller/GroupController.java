package com.detelin.kb.web.controller;

import com.detelin.kb.services.GroupService;
import com.detelin.kb.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/groups")
public class GroupController extends BaseController{
    private final UserService userService;
    private final GroupService groupService;
    private final ModelMapper mapper;
    @Autowired
    public GroupController(UserService userService, GroupService groupService, ModelMapper mapper) {
        this.userService = userService;
        this.groupService = groupService;
        this.mapper = mapper;
    }
    @GetMapping("/list")
    @PreAuthorize("isAuthenticated()")
//    @PreAuthorize(value = "hasAnyRole('ROLE_EDITOR','ROLE_ROOT')")
    public ModelAndView listAllGroups(ModelAndView modelAndView){
        modelAndView.addObject("groups",groupService.findAllGroups());
        return super.view("group/groupList",modelAndView);
    }
}
