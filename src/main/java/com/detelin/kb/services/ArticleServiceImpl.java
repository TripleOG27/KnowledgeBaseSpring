package com.detelin.kb.services;

import com.detelin.kb.domain.dto.ArticleDto;
import com.detelin.kb.domain.entities.ArticleEntity;
import com.detelin.kb.domain.repositories.ArticleRepository;
import com.detelin.kb.domain.repositories.UserRepository;
import com.detelin.kb.services.mapper.ArticleMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService{
    private final ArticleRepository articleRepository;
    private final ArticleMapper mapper;
    private final UserRepository userRepository;

    @Override
    public List<ArticleDto> findArticleByTitle(String wordInTitle) {
        return articleRepository.findByPatternInTitle(wordInTitle).stream()
                .map(mapper::toDto).toList();
    }

    @Override
    public List<ArticleDto> findArticleByKeyWord(String wordInSteps) {
        return null;
    }

    @Override
    public List<ArticleDto> findArticleByWordInDescription(String wordInDescription) {
        return null;
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public ArticleDto createArticle(ArticleDto dto, String authorName) {
        ArticleEntity articleEntity = mapper.toEntity(dto);
        articleEntity.setAuthor(userRepository.findByUsername(authorName).orElse(null));
        articleRepository.saveAndFlush(articleEntity);
        dto.setAuthor(authorName);
        return dto;
    }

    @Override
    public ArticleDto viewArticle(String id) {
        return mapper.toDto(articleRepository.findById(id).orElse(null));
    }

    @Override
    public void editArticle(ArticleDto dto) throws EntityNotFoundException {
        ArticleEntity articleEntity = articleRepository.findById(dto.getId()).orElse(null);
        if (null == articleEntity) {
            throw new EntityNotFoundException(String.format("Article with id %s not found", dto.getId()));
        }
        articleEntity.setDescription(dto.getDescription());
        articleEntity.setTitle(dto.getTitle());
        articleEntity.setWorkaround(dto.getWorkaround());
        articleEntity.setLongText(dto.getLongText());
        articleRepository.saveAndFlush(articleEntity);
    }

    @Override
    public List<ArticleDto> findAllByAuthorId(String id) {
        List<ArticleEntity> allByAuthorId = articleRepository.findAllByAuthorId(id);
        return allByAuthorId.stream().map(mapper::toDto).toList();
    }


}
