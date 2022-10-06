package com.fastrackit.SalaryRecipe.controller;

import com.fastrackit.SalaryRecipe.model.Employee.Employee;
import com.fastrackit.SalaryRecipe.model.Salary.Salary;
import com.fastrackit.SalaryRecipe.service.Employee.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class SalaryController {
    private EmployeeService service;


    public SalaryController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employee/{employeeid}")
    public Salary getSalaryforEmployee(@PathVariable Integer employeeid){
        return service.getSalaryFromEmployee(employeeid);
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        return service.getAllEmployee();
    }

    @GetMapping("/salary")
    public List<Salary> getAllSalaries(){
        return service.getAllSalaries();
    }



}
