package com.fastrackit.SalaryRecipe.controller;

import com.fastrackit.SalaryRecipe.dto.EmployeeDTO;
import com.fastrackit.SalaryRecipe.mapper.EmployeeMapper;
import com.fastrackit.SalaryRecipe.model.Employee;
import com.fastrackit.SalaryRecipe.service.EmployeeService;
import org.springframework.data.domain.Page;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    private EmployeeService service;

    @GetMapping("/employee")
//    @PreAuthorize("hasRole('Admin')")
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = service.getAllEmployee();
        List<EmployeeDTO> employeeDTOList = employeeList.stream()
                .map(EmployeeMapper::convertToDTO)
                .toList();
        return employeeDTOList;
    }

    @GetMapping("/employee/{employeeid}")
    public EmployeeDTO getEmployeeById(@PathVariable Integer employeeid) {
        Employee employee = service.getEmployeeById(employeeid);
        return EmployeeMapper.convertToDTO(employee);
    }

    @GetMapping("/page")
    public List<EmployeeDTO> findAll() {
        Page<Employee> abc = service.findAll();
        return abc.getContent().stream().map(EmployeeMapper::convertToDTO).toList();
    }

    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasRole('Admin')")
    public void deleteEmployee(@PathVariable Integer id) {
        service.deleteEmployee(id);
    }

    @PutMapping("/employee/{id}")
    public void giveFeedback(@PathVariable Integer id,
                             @RequestBody  Employee employee){
        service.postEmployee(id,employee);
    }


}
