package com.fastrackit.SalaryRecipe.model.Salary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fastrackit.SalaryRecipe.model.Employee.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column
    private Integer baseSalaryPerHour;
    @Column
    private Integer salaryOvertime;
    @Column
    private Integer employeeIncreas;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "employee_id")
    private Employee employee;

    public Salary(Integer baseSalaryPerHour, Integer salaryOvertime, Integer employeeIncreas) {
        this.baseSalaryPerHour = baseSalaryPerHour;
        this.salaryOvertime = salaryOvertime;
        this.employeeIncreas = employeeIncreas;
    }
}
