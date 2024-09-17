package com.detelin.kb.web.controller;

import com.detelin.kb.domain.dto.ArticleDto;
import com.detelin.kb.services.ArticleService;
import com.detelin.kb.services.UserService;
import com.detelin.kb.web.annotations.PageTitle;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/article")
@RequiredArgsConstructor
public class Article {
    private final ArticleService articleService;
    private final UserService userService;

    @GetMapping("/list/all")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("All articles")
    public ResponseEntity<List<ArticleDto>> getAllArticles() {
        return ResponseEntity.ok(articleService.findAll());
    }

    @PostMapping("/create")
    @PreAuthorize("isAuthenticated()")
    @PageTitle("Create an article")
    public ResponseEntity<ArticleDto> createArticle(@RequestBody ArticleDto dto, Principal principal){
        return ResponseEntity.ok(articleService.createArticle(dto, principal.getName()));
    }

    @GetMapping("/view/{id}")
    @PageTitle("View article")
    public ResponseEntity<ArticleDto> viewArticle(@PathVariable String id){
        return ResponseEntity.ok(articleService.viewArticle(id));
    }

    @PostMapping("/edit/{id}")
    @PageTitle("Edit Article")
    @PreAuthorize(value = "isAuthenticated()")
    public ResponseEntity<ArticleDto> editArticle(@PathVariable String id, @RequestBody ArticleDto dto) throws EntityNotFoundException {
        articleService.editArticle(dto);
        return ResponseEntity.ok(dto);
    }

    private String getLoggedInUserId(Principal principal){
        return userService.findUserByUsername(principal.getName()).getId();
    }

    @GetMapping(value = "/search", params = {"pattern"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(readOnly = true)
    public ResponseEntity<List<ArticleDto>> searchArticles(@RequestParam String pattern) {
        return ResponseEntity.ok(articleService.findArticleByTitle(pattern));
    }
}
