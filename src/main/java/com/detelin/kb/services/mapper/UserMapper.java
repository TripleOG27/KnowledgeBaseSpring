package com.detelin.kb.services.mapper;

import com.detelin.kb.config.ApplicationBeanConfiguration.BaseMapperConfig;
import com.detelin.kb.domain.dto.UserDto;
import com.detelin.kb.domain.entities.User;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapperConfig.class)
public abstract class UserMapper {
    public abstract UserDto toDto(User entity);

    public abstract User toEntity(UserDto dto);
}
