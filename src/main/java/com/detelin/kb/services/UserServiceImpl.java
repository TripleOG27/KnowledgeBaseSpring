package com.detelin.kb.services;

import com.detelin.kb.GlobalConstants;
import com.detelin.kb.domain.dto.UserDto;
import com.detelin.kb.domain.entities.User;
import com.detelin.kb.domain.enums.UserStatus;
import com.detelin.kb.domain.repositories.UserRepository;
import com.detelin.kb.services.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserMapper mapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto registerUser(UserDto dto) {
        roleService.seedRolesInDB();
        User user = mapper.toEntity(dto);
        if (this.userRepository.count()==0) {
            user.setAuthorities(this.roleService.findAllRoles());
        } else {
            user.setAuthorities(new LinkedHashSet<>());
            user.getAuthorities().add(this.roleService.findByAuthority(GlobalConstants.AUTHOR_ROLE));
        }
        user.setPassword(this.bCryptPasswordEncoder.encode(dto.getPassword()));
        user.setStatus(UserStatus.ACTIVE);
        user.setCreated(LocalDate.now());
        dto.setId(userRepository.saveAndFlush(user).getId());
        return dto;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username).orElseThrow(
                ()->new UsernameNotFoundException("Username not found")
        );
    }

    @Override
    public UserDto findUserByUsername(String username) {

        return this.userRepository.findByUsername(username).map(mapper::toDto)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
    }

    @Override
    public List<UserDto> findAllUsers() {
        return this.userRepository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public UserDto findUserById(String id) {
        return this.userRepository.findById(id).map(mapper::toDto)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
    }

    @Override
    public void setUserRole(String id, String role) {
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        user.getAuthorities().clear();
        user.getAuthorities().add(roleService.findByAuthority(role + "_ROLE"));
        userRepository.saveAndFlush(user);
    }

    @Override
    public void setStatus(String id, String status) {
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        user.setStatus(UserStatus.valueOf(status));
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public UserDto editUserProfile(UserDto dto, String oldPassword) {
        User user = this.userRepository.findByUsername(dto.getUsername())
                .orElseThrow(()-> new UsernameNotFoundException("Username not found!"));

        if (!bCryptPasswordEncoder.matches(oldPassword, user.getPassword())) {
            throw new IllegalArgumentException("Incorrect password!");
        }

        user.setPassword(!"".equals(dto.getPassword()) ?
                this.bCryptPasswordEncoder.encode(dto.getPassword()) :
                user.getPassword());
        user.setEmail(dto.getEmail());
//        user.setImageUrl(userServiceModel.getImageUrl());

        return this.mapper.toDto(this.userRepository.saveAndFlush(user));
    }

    @Override
    public UserDto userLogin(UserDto dto) {
        User user = userRepository.findByUsername(dto.getUsername()).orElse(null);
        if (null == user || !bCryptPasswordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new InputMismatchException();
        }
        return mapper.toDto(user);
    }
}
