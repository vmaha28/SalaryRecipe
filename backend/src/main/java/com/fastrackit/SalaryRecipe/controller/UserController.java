package com.fastrackit.SalaryRecipe.controller;

import com.fastrackit.SalaryRecipe.dto.UserDTO;
import com.fastrackit.SalaryRecipe.mapper.UserMapper;
import com.fastrackit.SalaryRecipe.model.User;
import com.fastrackit.SalaryRecipe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public UserDTO registerNewUser(@RequestBody UserDTO userDTO) {

        User user = userService.registerNewUser(UserMapper.convertToEntity(userDTO));
        return UserMapper.convertToDto(user);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin() {
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser() {
        return "This URL is only accessible to the user";
    }
}


