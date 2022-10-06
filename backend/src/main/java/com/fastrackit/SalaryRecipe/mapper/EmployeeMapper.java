package com.fastrackit.SalaryRecipe.mapper;

import com.fastrackit.SalaryRecipe.dto.EmployeeDTO;
import com.fastrackit.SalaryRecipe.model.Employee;

public class EmployeeMapper {

    public static EmployeeDTO convertToDTO(Employee employee) {
        return EmployeeDTO.builder()
                .id(employee.getId())
                .hoursWorked(employee.getHoursWorked())
                .name(employee.getName())
                .overtimeWorked(employee.getOvertimeWorked())
                .salary(SalaryMapper.convertToDTO(employee.getSalary()))
                .build();
    }
}
