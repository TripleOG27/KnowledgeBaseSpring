package com.detelin.kb.services;

import com.detelin.kb.domain.dto.UserDto;
import com.detelin.kb.domain.models.service.UserServiceModel;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserDto registerUser(UserDto userServiceModel);
    UserDto findUserByUsername(String username);
    UserDto findUserById(String id);
    List<UserDto> findAllUsers();

    void setUserRole(String id, String role);
    void setStatus(String id,String status);
    UserDto editUserProfile(UserDto dto, String oldPassword);

    UserDto userLogin(UserDto dto);
}
