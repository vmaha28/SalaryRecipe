package com.fastrackit.SalaryRecipe.service;

import com.fastrackit.SalaryRecipe.model.Employee;
import com.fastrackit.SalaryRecipe.model.Salary;
import com.fastrackit.SalaryRecipe.repository.EmployeeRepository;
import com.fastrackit.SalaryRecipe.repository.SalaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final SalaryRepository salaryRepository;

    public EmployeeService(EmployeeRepository employeeRepository, SalaryRepository salaryRepository, EmployeeProvider employeeProvider, SalaryProvider salaryProvider) {
        this.employeeRepository = employeeRepository;
        this.salaryRepository = salaryRepository;
        this.employeeRepository.saveAll(employeeProvider.getEmployee());
        this.salaryRepository.saveAll(salaryProvider.getSalary());
    }

    public List<Employee> getAllEmployee(){
//       return employeeRepository.findAll().stream().sorted(employee -> employee.getName().charAt(0));
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
//                .stream().sorted().collect(Collectors.toList());
    }

    public Salary getSalaryFromEmployee(Integer employeeId){
        return salaryRepository.findByEmployee_Id(employeeId);
    }

    public List<Salary> getAllSalaries(){
        return salaryRepository.findAll();
    }

}
