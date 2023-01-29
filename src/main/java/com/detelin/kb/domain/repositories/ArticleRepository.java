package com.detelin.kb.domain.repositories;

import com.detelin.kb.domain.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article,String> {
    @Override
    Optional<Article> findById(String s);

    @Override
    List<Article> findAll();
}
