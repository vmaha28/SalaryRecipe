package com.fastrackit.SalaryRecipe.repository;

import com.fastrackit.SalaryRecipe.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


}
