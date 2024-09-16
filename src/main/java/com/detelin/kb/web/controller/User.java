package com.detelin.kb.web.controller;

import com.detelin.kb.domain.dto.UserDto;
import com.detelin.kb.services.RoleService;
import com.detelin.kb.services.UserService;
import com.detelin.kb.web.annotations.PageTitle;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.InputMismatchException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class User {
    private final UserService userService;
    private final RoleService roleService;

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ResponseEntity<UserDto> register(@RequestBody UserDto dto) {
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            throw new InputMismatchException();
        }

        return ResponseEntity.ok(userService.registerUser(dto));
    }

    @PostMapping("/login")
    @PreAuthorize("isAnonymous()")
    public ResponseEntity<UserDto> login(@RequestBody UserDto dto) {
        UserDto userDto = userService.userLogin(dto);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/edit")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<UserDto> editProfile(@RequestBody UserDto dto) {
        return ResponseEntity.ok(userService.editUserProfile(dto, dto.getPassword()));
    }

    @GetMapping("/list")
    @PreAuthorize(value = "hasAnyRole('ROLE_ROOT','ROOT_ROLE')")
    @PageTitle("All Users")
    public ResponseEntity<List<UserDto>> listAllUsers() {
        List<UserDto> users = this.userService.findAllUsers();

        return ResponseEntity.ok(users);
    }

    @PostMapping("/privilege/{id}")
    @PreAuthorize("hasAnyRole('ROLE_PRIVILEGES')")
    public ResponseEntity<UserDto> setUserRole(@PathVariable String id, @RequestParam(name = "authority",required = false) String role ) {

        userService.setUserRole(id, role);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/status/{id}")
    @PreAuthorize("hasAnyRole('ROLE_TSM')")
    public ResponseEntity<UserDto> setUserStatus(@PathVariable String id, @RequestParam(name = "status", required = false) String status ) {
        this.userService.setStatus(id, status);

        return ResponseEntity.ok().build();
    }


}
