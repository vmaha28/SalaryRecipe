package com.fastrackit.SalaryRecipe.service.Employee;

import com.fastrackit.SalaryRecipe.model.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
