package com.detelin.kb.domain.repositories;

import com.detelin.kb.domain.entities.Article;
import com.detelin.kb.domain.models.view.ArticleViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article,String> {
    @Override
    Optional<Article> findById(String s);

    @Override
    List<Article> findAll();
    @Query(value = "select * from articles where user_id=?1",nativeQuery = true)
    List<Article> findAllByAuthorId(String id);
}
