package com.detelin.kb.domain.models.view;

import com.detelin.kb.GlobalConstants;
import com.detelin.kb.domain.enums.UserStatus;

import java.time.LocalDate;
import java.util.Set;

public class UserAllViewModel {
    private String id;
    private String username;
    private String email;
    private UserStatus status;
    private LocalDate created;
    private Set<String> authorities;
    private String highestAuthority;
    private String imageUrl;

    public UserAllViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getHighestAuthority() {
        return highestAuthority;
    }

    public void setHighestAuthority() {
        if(authorities.contains(GlobalConstants.ROOT_ROLE))this.highestAuthority = "Root";
        else if(authorities.contains(GlobalConstants.EDITOR_ROLE))this.highestAuthority = "Editor";
        else if(authorities.contains(GlobalConstants.AUTHOR_ROLE))this.highestAuthority = "Author";
        else if(authorities.contains(GlobalConstants.GUEST_ROLE))this.highestAuthority = "Guest";
        else this.highestAuthority = "Customer";
    }

//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
