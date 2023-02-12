package com.detelin.kb.domain.entities;

import com.detelin.kb.domain.enums.UserStatus;
import jakarta.persistence.*;

import java.util.Set;
@Entity
@Table(name = "user_groups")
public class Group extends BaseEntity{
    private String name;
    private Set<Role> roles;
    private Set<User> members;
    private String email;
    private UserStatus groupStatus;

    public Group() {
    }
    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    public UserStatus getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(UserStatus groupStatus) {
        this.groupStatus = groupStatus;
    }


    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @ManyToOne(targetEntity = Role.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    @OneToMany(targetEntity = User.class,fetch = FetchType.EAGER)
    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
