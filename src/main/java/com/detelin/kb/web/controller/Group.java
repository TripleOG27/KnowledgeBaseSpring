package com.detelin.kb.web.controller;

import com.detelin.kb.domain.dto.GroupDto;
import com.detelin.kb.services.GroupService;
import com.detelin.kb.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class Group {
    private final UserService userService;
    private final GroupService groupService;

    @GetMapping("/list")
    @PreAuthorize("isAuthenticated()")
//    @PreAuthorize(value = "hasAnyRole('ROLE_EDITOR','ROLE_ROOT')")
    public ResponseEntity<List<GroupDto>> listAllGroups() {
        return ResponseEntity.ok(groupService.findAllGroups());
    }
}
