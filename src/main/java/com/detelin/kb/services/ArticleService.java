package com.detelin.kb.services;

import com.detelin.kb.domain.dto.ArticleDto;

import java.util.List;

public interface ArticleService {
    List<ArticleDto> findArticleByTitle(String wordInTitle);
    List<ArticleDto> findArticleByKeyWord(String wordInSteps);
    List<ArticleDto> findArticleByWordInDescription(String wordInDescription);
    List<ArticleDto> findAll();

    ArticleDto createArticle(ArticleDto articleDto, String authorName);
    ArticleDto viewArticle(String id);

    void editArticle(ArticleDto articleViewModel);

    List<ArticleDto> findAllByAuthorId(String id);
}
