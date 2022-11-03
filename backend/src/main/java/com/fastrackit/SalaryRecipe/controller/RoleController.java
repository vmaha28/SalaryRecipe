package com.fastrackit.SalaryRecipe.controller;

import com.fastrackit.SalaryRecipe.dto.RoleDTO;
import com.fastrackit.SalaryRecipe.mapper.RoleMapper;
import com.fastrackit.SalaryRecipe.model.Role;
import com.fastrackit.SalaryRecipe.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping({"/createNewRole"})
    @PreAuthorize("hasRole('Admin')")
    public RoleDTO createNewRole(@RequestBody RoleDTO roleDTO) {

        Role role=roleService.createNewRole(RoleMapper.convertToEntity(roleDTO));

        return RoleMapper.convertToDto(role);
    }
}