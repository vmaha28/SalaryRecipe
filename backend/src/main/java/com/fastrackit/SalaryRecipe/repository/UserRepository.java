package com.fastrackit.SalaryRecipe.repository;

import com.fastrackit.SalaryRecipe.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User, String> {
}
