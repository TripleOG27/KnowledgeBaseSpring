package com.detelin.kb.services;

import com.detelin.kb.domain.dto.GroupDto;

import java.util.List;

public interface GroupService {
//    List<UserAllViewModel> findAllUsers();
    List<GroupDto> findAllUsersInGroup(String id);
    List<GroupDto> findAllGroups();
    void setRole(GroupDto dto, String role_id);
}
