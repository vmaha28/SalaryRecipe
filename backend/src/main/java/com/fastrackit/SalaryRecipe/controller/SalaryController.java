package com.fastrackit.SalaryRecipe.controller;

import com.fastrackit.SalaryRecipe.dto.EmployeeDTO;
import com.fastrackit.SalaryRecipe.dto.SalaryDTO;
import com.fastrackit.SalaryRecipe.mapper.EmployeeMapper;
import com.fastrackit.SalaryRecipe.mapper.SalaryMapper;
import com.fastrackit.SalaryRecipe.model.Employee;
import com.fastrackit.SalaryRecipe.model.Salary;
import com.fastrackit.SalaryRecipe.service.EmployeeService;
import com.fastrackit.SalaryRecipe.service.SalaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SalaryController {
    private SalaryService service;


    public SalaryController(SalaryService service) {
        this.service = service;
    }

    @GetMapping("/salary/{employeeid}")
    public SalaryDTO getSalaryforEmployee(@PathVariable Integer employeeid){
        Salary salary = service.getSalaryFromEmployee(employeeid);
        return SalaryMapper.convertToDTO(salary);
    }



    @GetMapping("/salary")
    public List<SalaryDTO> getAllSalaries(){
        List<Salary> salaryList = service.getAllSalaries();
        List<SalaryDTO> salaryDTOList = salaryList.stream().map(SalaryMapper::convertToDTO).toList();;
        return salaryDTOList;
    }






}
