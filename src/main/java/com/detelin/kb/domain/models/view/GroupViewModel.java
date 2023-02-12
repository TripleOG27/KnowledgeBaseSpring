package com.detelin.kb.domain.models.view;

import com.detelin.kb.domain.entities.Role;
import com.detelin.kb.domain.entities.User;
import com.detelin.kb.domain.enums.UserStatus;

import java.util.Set;

public class GroupViewModel extends BaseViewModel{
    private String name;
    private Set<Role> roles;
    private Set<User> members;
    private String email;
    private UserStatus groupStatus;

    public GroupViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserStatus getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(UserStatus groupStatus) {
        this.groupStatus = groupStatus;
    }
}
