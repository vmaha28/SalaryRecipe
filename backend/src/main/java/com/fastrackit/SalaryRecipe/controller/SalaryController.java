package com.fastrackit.SalaryRecipe.controller;

import com.fastrackit.SalaryRecipe.dto.SalaryDTO;
import com.fastrackit.SalaryRecipe.mapper.SalaryMapper;
import com.fastrackit.SalaryRecipe.model.Salary;
import com.fastrackit.SalaryRecipe.service.SalaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
