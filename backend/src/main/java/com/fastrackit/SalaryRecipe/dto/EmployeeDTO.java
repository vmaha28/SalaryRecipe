package com.fastrackit.SalaryRecipe.dto;

import com.fastrackit.SalaryRecipe.model.Salary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
    private Integer id;
    private String name;
    private Integer hoursWorked;
    private Integer overtimeWorked;
    private SalaryDTO salary;
}
