package com.detelin.kb.services;

import com.detelin.kb.domain.models.view.GroupViewModel;
import com.detelin.kb.domain.models.view.UserAllViewModel;

import java.util.List;

public interface GroupService {
//    List<UserAllViewModel> findAllUsers();
    List<UserAllViewModel> findAllUsersInGroup(String id);
    List<GroupViewModel> findAllGroups();
    void setRole(GroupViewModel groupViewModel,String role_id);
}
