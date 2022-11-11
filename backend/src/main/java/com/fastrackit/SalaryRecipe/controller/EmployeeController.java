package com.fastrackit.SalaryRecipe.controller;

import com.fastrackit.SalaryRecipe.dto.CreateEmployeeDTO;
import com.fastrackit.SalaryRecipe.dto.EmployeeDTO;
import com.fastrackit.SalaryRecipe.dto.ListResultsDTO;
import com.fastrackit.SalaryRecipe.mapper.EmployeeMapper;
import com.fastrackit.SalaryRecipe.model.Employee;
import com.fastrackit.SalaryRecipe.service.EmployeeService;
import org.springframework.data.domain.Page;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    private EmployeeService service;

    @GetMapping("/employee/all")
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

    @GetMapping("/employee")
    public ListResultsDTO<EmployeeDTO> findAll(@RequestParam int pageIndex, @RequestParam int pageSize) {


        Page<Employee> abc = service.findAll(pageIndex, pageSize);
        List<EmployeeDTO> employeeList = abc.getContent().stream().map(EmployeeMapper::convertToDTO).toList();
        long totalEmployeesCount=service.countTotalEmployees();

        return ListResultsDTO.<EmployeeDTO>builder()
                .results(employeeList)
                .totalRecords(totalEmployeesCount)
                .build();
    }

    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasRole('Admin')")
    public void deleteEmployee(@PathVariable Integer id) {
        service.deleteEmployee(id);
    }

    @PutMapping("/employee/{id}")
    public EmployeeDTO updateEmployee(@PathVariable Integer id,
                             @RequestBody CreateEmployeeDTO employee){
        Employee employeee=EmployeeMapper.convertToEntity(id,employee);
       return  EmployeeMapper.convertToDTO(service.putEmployee(id,employeee));
    }



}
