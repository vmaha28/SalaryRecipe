package com.fastrackit.SalaryRecipe.repository;

import com.fastrackit.SalaryRecipe.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends  JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {


}
