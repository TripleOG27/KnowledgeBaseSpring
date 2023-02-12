package com.detelin.kb.services;

import com.detelin.kb.domain.entities.Article;
import com.detelin.kb.domain.models.binding.ArticleCreateBindingModel;
import com.detelin.kb.domain.models.service.ArticleServiceModel;
import com.detelin.kb.domain.models.view.ArticleViewModel;
import com.detelin.kb.domain.repositories.ArticleRepository;
import com.detelin.kb.domain.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceimpl  implements ArticleService{
    private final ArticleRepository articleRepository;
    private final ModelMapper mapper;
    private final UserRepository userRepository;

    public ArticleServiceimpl(ArticleRepository articleRepository, ModelMapper mapper, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.mapper = mapper;
        this.userRepository = userRepository;
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
    public ArticleViewModel createArticle(ArticleCreateBindingModel articleCreateBindingModel, String _authorName) {
        articleCreateBindingModel.setAuthor(userRepository.findByUsername(_authorName).orElse(null));
        Article savedArticle = articleRepository.save(this.mapper.map(articleCreateBindingModel, Article.class));
        articleRepository.flush();
        return mapper.map(savedArticle,ArticleViewModel.class);
    }

    @Override
    public ArticleViewModel viewArticle(String id) {
        return mapper.map(articleRepository.findById(id).orElse(null),ArticleViewModel.class);
    }

    @Override
    public void editArticle(ArticleViewModel articleViewModel) {
        Article article = articleRepository.findById(articleViewModel.getId()).orElse(null);
        article.setDescription(articleViewModel.getDescription());
        article.setTitle(articleViewModel.getTitle());
        article.setWorkaround(articleViewModel.getWorkaround());
        article.setLongText(articleViewModel.getLongText());
        articleRepository.saveAndFlush(article);
    }

}
