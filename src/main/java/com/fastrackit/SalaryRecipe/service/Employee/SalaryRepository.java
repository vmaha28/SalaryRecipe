package com.fastrackit.SalaryRecipe.service.Employee;

import com.fastrackit.SalaryRecipe.model.Employee.Employee;
import com.fastrackit.SalaryRecipe.model.Salary.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary,Integer> {
    public Salary findByEmployee(Employee employee);
}
