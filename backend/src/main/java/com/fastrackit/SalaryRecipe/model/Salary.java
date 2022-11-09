package com.fastrackit.SalaryRecipe.model;

import com.fastrackit.SalaryRecipe.model.Employee;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="salary")
public class  Salary {
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

    public Salary(int baseSalaryPerHour, int salaryOvertime, int employeeIncreas, int employeeId) {
        this.baseSalaryPerHour = baseSalaryPerHour;
        this.salaryOvertime = salaryOvertime;
        this.employeeIncreas = employeeIncreas;
        this.employee = Employee.builder().id(employeeId).build();
    }
}
