package com.fastrackit.SalaryRecipe.service;

import com.fastrackit.SalaryRecipe.model.Employee;
import com.fastrackit.SalaryRecipe.repository.EmployeeRepository;
import com.fastrackit.SalaryRecipe.repository.SalaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository, SalaryRepository salaryRepository, EmployeeProvider employeeProvider, SalaryProvider salaryProvider) {
        this.employeeRepository = employeeRepository;


    }

    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }


}
