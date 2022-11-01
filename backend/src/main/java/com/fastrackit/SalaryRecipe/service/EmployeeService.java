package com.fastrackit.SalaryRecipe.service;

import com.fastrackit.SalaryRecipe.model.Employee;
import com.fastrackit.SalaryRecipe.repository.EmployeeRepository;
import com.fastrackit.SalaryRecipe.repository.SalaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;



    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }


}
