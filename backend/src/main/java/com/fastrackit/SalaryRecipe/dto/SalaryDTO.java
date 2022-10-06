package com.fastrackit.SalaryRecipe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalaryDTO {
    private Integer id;
    private Integer baseSalaryPerHour;
    private Integer salaryOvertime;
    private Integer employeeIncreas;
}
