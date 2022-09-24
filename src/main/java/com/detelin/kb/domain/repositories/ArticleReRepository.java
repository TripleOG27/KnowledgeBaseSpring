package com.detelin.kb.domain.repositories;

import com.detelin.kb.domain.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleReRepository extends JpaRepository<Article,String> {
}
