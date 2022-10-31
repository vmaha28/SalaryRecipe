package com.fastrackit.SalaryRecipe.service;

import com.fastrackit.SalaryRecipe.exception.ResourceNotFoundException;
import com.fastrackit.SalaryRecipe.model.Salary;
import com.fastrackit.SalaryRecipe.repository.SalaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {
    private final SalaryRepository salaryRepository;

    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    public Salary getSalaryFromEmployee(Integer employeeId){
        Salary result = salaryRepository.findByEmployee_Id(employeeId);
        if(result == null){
            throw new ResourceNotFoundException("Invalid Employee ID");
        }
        return result;
    }
    public List<Salary> getAllSalaries(){
        return salaryRepository.findAll();
    }

}
