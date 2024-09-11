package com.detelin.kb.web.restcontroller;

import com.detelin.kb.domain.models.service.ArticleServiceModel;
import com.detelin.kb.services.ArticleService;
import com.detelin.kb.web.annotations.PageTitle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeRestController {
    private final ArticleService articleService;
    private final ObjectMapper objectMapper;

//    @GetMapping(value = "/")
//    @PageTitle("Index")
//    @ResponseBody()
//    public String index() {
//        return null;
//    }

    @GetMapping(value = "/api/search", params = {"pattern"})
    @Transactional(readOnly = true)
    public String searchArticles(@RequestParam String pattern) throws JsonProcessingException {
        List<ArticleServiceModel> articleByTitle = articleService.findArticleByTitle(pattern);

        return objectMapper.writeValueAsString(articleByTitle);
    }
}
