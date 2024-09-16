package com.detelin.kb.services;

import com.detelin.kb.domain.dto.GroupDto;
import com.detelin.kb.domain.entities.Group;
import com.detelin.kb.domain.repositories.GroupRepository;
import com.detelin.kb.services.mapper.GroupMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
     private final GroupRepository groupRepository;
    private final RoleService roleService;
    private final GroupMapper mapper;

    @Override
    public List<GroupDto> findAllUsersInGroup(String id) {
        return null;
    }

    @Override
    public List<GroupDto> findAllGroups() {
        return groupRepository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public void setRole(GroupDto dto, String role) {
        Group group = groupRepository.findById(dto.getId()).orElse(null);
        group.setRoles(new HashSet<>());
        group.getRoles().add(roleService.findByAuthority(role));
        groupRepository.saveAndFlush(group);
    }
}
