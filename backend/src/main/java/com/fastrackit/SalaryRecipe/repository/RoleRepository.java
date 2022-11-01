package com.fastrackit.SalaryRecipe.repository;

import com.fastrackit.SalaryRecipe.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, String> {
}
