package com.fastrackit.SalaryRecipe.mapper;

import com.fastrackit.SalaryRecipe.dto.RoleDTO;
import com.fastrackit.SalaryRecipe.model.Role;

public class RoleMapper {

    public static RoleDTO convertToDto(Role role){
        return RoleDTO.builder()
                .roleName(role.getRoleName())
                .roleDescription(role.getRoleDescription())
                .build();
    }

    public static Role convertToEntity(RoleDTO roleDTO){
        return Role.builder()
                .roleName(roleDTO.getRoleName())
                .roleDescription(roleDTO.getRoleDescription())
                .build();
    }
}
