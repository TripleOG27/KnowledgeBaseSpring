package com.detelin.kb.domain.repositories;

import com.detelin.kb.domain.entities.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<ArticleEntity, String> {
    @Override
    Optional<ArticleEntity> findById(String s);

    @Override
    List<ArticleEntity> findAll();

    @Query(value = "SELECT * FROM articles WHERE user_id = :id", nativeQuery = true)
    List<ArticleEntity> findAllByAuthorId(@Param("id") String id);

    @Query(value = "SELECT * FROM articles WHERE title LIKE CONCAT('%', :pattern, '%')", nativeQuery = true)
    List<ArticleEntity> findByPatternInTitle(@Param("pattern") String pattern);
}
