package com.detelin.kb.services;

import com.detelin.kb.domain.entities.Group;
import com.detelin.kb.domain.entities.Role;
import com.detelin.kb.domain.models.view.GroupViewModel;
import com.detelin.kb.domain.models.view.UserAllViewModel;
import com.detelin.kb.domain.repositories.GroupRepository;
import com.detelin.kb.domain.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService{
    private final GroupRepository groupRepository;
    private final RoleService roleService;
    private final ModelMapper mapper;

    public GroupServiceImpl(GroupRepository groupRepository, RoleService roleService, ModelMapper mapper) {
        this.groupRepository = groupRepository;
        this.roleService = roleService;
        this.mapper = mapper;
    }

    @Override
    public List<UserAllViewModel> findAllUsersInGroup(String id) {
        return null;
    }

    @Override
    public List<GroupViewModel> findAllGroups() {
        return groupRepository.findAll().stream().map(g->mapper.map(g,GroupViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public void setRole(GroupViewModel groupViewModel, String role) {
        groupViewModel.setRoles(new HashSet<>());
        groupViewModel.getRoles().add(mapper.map(roleService.findByAuthority(role), Role.class));
        groupRepository.saveAndFlush(mapper.map(groupViewModel, Group.class));
    }
}
