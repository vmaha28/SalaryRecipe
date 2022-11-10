package com.fastrackit.SalaryRecipe.mapper;

import com.fastrackit.SalaryRecipe.dto.CreateEmployeeDTO;
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

    public static Employee convertToEntity(EmployeeDTO employeeDTO){
        return Employee.builder()
                .id(employeeDTO.getId())
                .name(employeeDTO.getName())
                .hoursWorked(employeeDTO.getHoursWorked())
                .overtimeWorked(employeeDTO.getOvertimeWorked())
                .salary(SalaryMapper.convertToEntity(employeeDTO.getSalary())).build();
    }

    public static Employee convertToEntity(Integer employeeId,CreateEmployeeDTO employee) {
        return Employee.builder()
                .id(employeeId)
                .name(employee.getName())
                .hoursWorked(employee.getHoursWorked())
                .overtimeWorked(employee.getOvertimeWorked())
                .build();

    }
}
