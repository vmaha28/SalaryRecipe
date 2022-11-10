package com.fastrackit.SalaryRecipe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateEmployeeDTO {
    private String name;
    private Integer hoursWorked;
    private Integer overtimeWorked;

}