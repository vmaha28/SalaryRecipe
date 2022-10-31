package com.fastrackit.SalaryRecipe.service;

import com.fastrackit.SalaryRecipe.model.Role;
import com.fastrackit.SalaryRecipe.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class RoleService {
        @Autowired
        private RoleRepository roleRepository;

        public Role createNewRole(Role role) {
            return roleRepository.save(role);
        }
    }


