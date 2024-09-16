package com.detelin.kb.services.mapper;

import com.detelin.kb.config.ApplicationBeanConfiguration.BaseMapperConfig;
import com.detelin.kb.domain.dto.ArticleDto;
import com.detelin.kb.domain.entities.ArticleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = BaseMapperConfig.class)
public abstract class ArticleMapper {
    @Mapping(target = "author", ignore = true)
    public abstract ArticleDto toDto(ArticleEntity articleEntity);

    @Mapping(target = "author", ignore = true)
    public abstract ArticleEntity toEntity(ArticleDto dto);
}
