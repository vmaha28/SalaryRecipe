package com.fastrackit.SalaryRecipe.dto;

import com.fastrackit.SalaryRecipe.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private String userName;

    private String userFirstName;

    private String userLastName;

    private String userPassword;

    private Set<RoleDTO> role;
}
