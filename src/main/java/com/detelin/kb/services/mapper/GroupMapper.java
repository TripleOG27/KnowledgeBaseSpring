package com.detelin.kb.services.mapper;

import com.detelin.kb.config.ApplicationBeanConfiguration.BaseMapperConfig;
import com.detelin.kb.domain.dto.GroupDto;
import com.detelin.kb.domain.entities.Group;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapperConfig.class)
public abstract class GroupMapper {
    public abstract GroupDto toDto(Group entity);

    public abstract Group toEntity(GroupDto dto);
}
