package com.fastrackit.SalaryRecipe.controller;

import com.fastrackit.SalaryRecipe.dto.EmployeeDTO;
import com.fastrackit.SalaryRecipe.mapper.EmployeeMapper;
import com.fastrackit.SalaryRecipe.model.Employee;
import com.fastrackit.SalaryRecipe.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    private EmployeeService service;

    @GetMapping("/employee")
    public List<EmployeeDTO> getAllEmployees(){
        List<Employee> employeeList = service.getAllEmployee();
        List<EmployeeDTO> employeeDTOList = employeeList.stream()
                .map(EmployeeMapper::convertToDTO)
                .toList();
        return employeeDTOList;
    }
}
