package com.detelin.kb.domain.repositories;

import com.detelin.kb.domain.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleReRepository extends JpaRepository<Article,String> {
    @Override
    List<Article> findAll();

    @Override
    Optional<Article> findById(String s);
}
