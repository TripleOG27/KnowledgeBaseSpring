package com.detelin.kb.domain.dto;

import com.detelin.kb.domain.entities.Role;
import com.detelin.kb.domain.entities.User;
import com.detelin.kb.domain.enums.UserStatus;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {
    private String id;
    private String name;
    private Set<Role> roles;
    private Set<User> members;
    private String email;
    private UserStatus groupStatus;
}
