package com.detelin.kb.domain.repositories;

import com.detelin.kb.domain.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, String> {
    @Override
    Optional<Article> findById(String s);

    @Override
    List<Article> findAll();

    @Query(value = "SELECT * FROM articles WHERE user_id = :id", nativeQuery = true)
    List<Article> findAllByAuthorId(@Param("id") String id);

    @Query(value = "SELECT * FROM articles WHERE title LIKE CONCAT('%', :pattern, '%')", nativeQuery = true)
    List<Article> findByPatternInTitle(@Param("pattern") String pattern);
}
