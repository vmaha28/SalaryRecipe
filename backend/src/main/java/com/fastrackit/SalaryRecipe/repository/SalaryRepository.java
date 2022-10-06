package com.fastrackit.SalaryRecipe.repository;

import com.fastrackit.SalaryRecipe.model.Employee;
import com.fastrackit.SalaryRecipe.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary,Integer> {
    public Salary findByEmployee(Employee employee);
    public Salary findByEmployee_Id(Integer employeeId);

}
