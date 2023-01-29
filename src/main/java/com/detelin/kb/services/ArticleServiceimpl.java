package com.detelin.kb.services;

import com.detelin.kb.domain.entities.Article;
import com.detelin.kb.domain.models.service.ArticleServiceModel;
import com.detelin.kb.domain.models.view.ArticleViewModel;
import com.detelin.kb.domain.repositories.ArticleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceimpl  implements ArticleService{
    private final ArticleRepository articleRepository;
    private final ModelMapper mapper;

    public ArticleServiceimpl(ArticleRepository articleRepository, ModelMapper mapper) {
        this.articleRepository = articleRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ArticleServiceModel> findArticleByTitle(String wordInTitle) {
        return null;
    }

    @Override
    public List<ArticleServiceModel> findArticleByKeyWorkd(String wordInSteps) {
        return null;
    }

    @Override
    public List<ArticleServiceModel> findArticleByWordInDescription(String wordInDescription) {
        return null;
    }

    @Override
    public List<ArticleServiceModel> findAll() {
        return null;
    }

    @Override
    public ArticleViewModel createArticle(ArticleServiceModel articleServiceModel) {
        articleRepository.saveAndFlush(this.mapper.map(articleServiceModel, Article.class));
        ArticleViewModel articleViewModel = mapper.map(articleRepository.findById(articleServiceModel.getId()).orElse(null),ArticleViewModel.class);
        return articleViewModel;
    }

    @Override
    public ArticleViewModel viewArticle(String id) {
        return mapper.map(articleRepository.findById(id).orElse(null),ArticleViewModel.class);
    }

}
