package com.detelin.kb.services;

import com.detelin.kb.domain.models.binding.ArticleCreateBindingModel;
import com.detelin.kb.domain.models.service.ArticleServiceModel;
import com.detelin.kb.domain.models.view.ArticleViewModel;

import java.util.List;

public interface ArticleService {
    List<ArticleServiceModel> findArticleByTitle(String wordInTitle);
    List<ArticleServiceModel> findArticleByKeyWorkd(String wordInSteps);
    List<ArticleServiceModel> findArticleByWordInDescription(String wordInDescription);
    List<ArticleServiceModel> findAll();

    ArticleViewModel createArticle(ArticleCreateBindingModel articleServiceModel, String authorName);
    ArticleViewModel viewArticle(String id);
}
