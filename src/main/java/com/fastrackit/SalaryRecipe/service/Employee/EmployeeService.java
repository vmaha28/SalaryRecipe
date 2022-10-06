package com.fastrackit.SalaryRecipe.service.Employee;

import com.fastrackit.SalaryRecipe.model.Employee.Employee;
import com.fastrackit.SalaryRecipe.model.Salary.Salary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return employeeRepository.findAll();
//                .stream().sorted().collect(Collectors.toList());
    }

    public Salary getSalaryFromEmployee(Integer employeeId){
        return salaryRepository.findByEmployee(employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found")));
    }

    public List<Salary> getAllSalaries(){
        return salaryRepository.findAll();
    }

}
