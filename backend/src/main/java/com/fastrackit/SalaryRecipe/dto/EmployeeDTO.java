package com.fastrackit.SalaryRecipe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
    private Integer id;
    private String name;
    private String surname;
    private Integer hoursWorked;
    private Integer overtimeWorked;
    private SalaryDTO salary;
}
