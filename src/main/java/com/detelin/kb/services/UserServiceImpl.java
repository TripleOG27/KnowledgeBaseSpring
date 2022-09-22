package com.detelin.kb.services;

import com.detelin.kb.domain.models.service.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UserServiceImpl implements UserService{
    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        return null;
    }

    @Override
    public UserServiceModel findUserByUsername(String username) {
        return null;
    }

    @Override
    public UserServiceModel findUserById(String id) {
        return null;
    }

    @Override
    public List<UserServiceModel> findAllUsers() {
        return null;
    }

    @Override
    public void setUserRole(String id, String role) {

    }

    @Override
    public void setStatus(String id, String status) {

    }

    @Override
    public UserServiceModel editUserProfile(UserServiceModel userServiceModel, String oldPassword) {
        return null;
    }

    @Override
    public UserServiceModel findAnActiveUserToAssignACase() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
