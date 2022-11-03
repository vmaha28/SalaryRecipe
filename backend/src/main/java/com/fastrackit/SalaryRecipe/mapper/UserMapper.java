package com.fastrackit.SalaryRecipe.mapper;

import com.fastrackit.SalaryRecipe.dto.RoleDTO;
import com.fastrackit.SalaryRecipe.dto.UserDTO;
import com.fastrackit.SalaryRecipe.model.Role;
import com.fastrackit.SalaryRecipe.model.User;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper {


    public static UserDTO convertToDto(User user) {
//        Set<RoleDTO> roles = new HashSet<>();
//        for (Role role : user.getRole()) {
//            roles.add(RoleMapper.convertToDto(role));
//        }

        return UserDTO.builder()
                .userName(user.getUserName())
                .userFirstName(user.getUserFirstName())
                .userLastName(user.getUserLastName())
                .userPassword(user.getUserPassword())
                .role(user.getRole().stream().map(RoleMapper::convertToDto).collect(Collectors.toSet()))
                .build();
    }

    public static User convertToEntity(UserDTO userDTO) {
        return User.builder()
                .userName(userDTO.getUserName())
                .userFirstName(userDTO.getUserFirstName())
                .userLastName(userDTO.getUserLastName())
                .userPassword(userDTO.getUserPassword())
                .build();
    }
}
