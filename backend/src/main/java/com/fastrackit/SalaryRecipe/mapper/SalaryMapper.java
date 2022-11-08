package com.fastrackit.SalaryRecipe.mapper;

import com.fastrackit.SalaryRecipe.dto.SalaryDTO;
import com.fastrackit.SalaryRecipe.model.Salary;

public class SalaryMapper {
    public static SalaryDTO convertToDTO(Salary salary) {
        return SalaryDTO.builder()
                .baseSalaryPerHour(salary.getBaseSalaryPerHour())
                .salaryOvertime(salary.getSalaryOvertime())
                .employeeIncreas(salary.getEmployeeIncreas())
                .id(salary.getId())
                .build();
    }

    public static Salary convertToEntity(SalaryDTO salaryDTO) {
        return Salary.builder()
                .baseSalaryPerHour(salaryDTO.getBaseSalaryPerHour())
                .salaryOvertime(salaryDTO.getSalaryOvertime())
                .employeeIncreas(salaryDTO.getEmployeeIncreas())
                .id(salaryDTO.getId())
                .build();

    }
}
