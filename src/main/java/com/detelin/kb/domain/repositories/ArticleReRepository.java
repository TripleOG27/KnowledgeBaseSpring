package com.detelin.kb.domain.repositories;

import com.detelin.kb.domain.entities.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleReRepository extends JpaRepository<ArticleEntity,String> {
    @Override
    List<ArticleEntity> findAll();

    @Override
    Optional<ArticleEntity> findById(String s);
}
