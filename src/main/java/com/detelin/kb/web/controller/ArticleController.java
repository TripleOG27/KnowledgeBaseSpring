package com.detelin.kb.web.controller;

import com.detelin.kb.domain.models.binding.ArticleCreateBindingModel;
import com.detelin.kb.domain.models.service.ArticleServiceModel;
import com.detelin.kb.services.ArticleService;
import com.detelin.kb.services.UserService;
import com.detelin.kb.web.annotations.PageTitle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.time.LocalDate;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequestMapping("/articles")
public class ArticleController extends BaseController{
    private final ArticleService articleService;
    private final UserService userService;
    private final ModelMapper mapper;
    @Autowired
    public ArticleController(ArticleService articleService, UserService userService, ModelMapper mapper) {
        this.articleService = articleService;
        this.userService = userService;
        this.mapper = mapper;
    }
    @GetMapping("/all_articles")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("All articles")
    public ModelAndView getAllArticles(ModelAndView modelAndView, Principal principal){
        modelAndView.addObject("articles",this.articleService.findAll());
        modelAndView.addObject("username",principal.getName());
        return super.view("article/all_articles",modelAndView);
    }

    @GetMapping("/create")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("Create an article")
    public ModelAndView createArticle(ModelAndView modelAndView,Principal principal){
        return super.view("article/articleCreate",modelAndView);
    }
    @PostMapping("/create")
    @PreAuthorize(value = "isAuthenticated()")
    public ModelAndView createArticleConfirm(@ModelAttribute ArticleCreateBindingModel articleCreateBindingModel, Principal principal, RedirectAttributes redirectAttributes){
        articleCreateBindingModel.setCreatedDate(LocalDate.now());
        articleCreateBindingModel.setAuthor(userService.findUserByUsername(principal.getName()).getId());
        return super.redirect("/articles/view/" +
                (articleService.createArticle(this.mapper.map(articleCreateBindingModel, ArticleServiceModel.class)))
                        .getId()
        );

    }
    @GetMapping("/view/{id}")
    @PageTitle("View article")
    public ModelAndView viewArticle(@PathVariable String id, ModelAndView modelAndView){
        modelAndView.addObject("article",articleService.viewArticle(id));
        return super.view("article/articleView",modelAndView);
    }

}
