package com.fastrackit.SalaryRecipe.model;

import lombok.*;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column
    private String name;

    @Column
    private String surname;
    @Column
    private Integer hoursWorked;
    @Column
    private Integer overtimeWorked;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
    private Salary salary;

    public Employee(String name, Integer hoursWorked, Integer overtimeWorked) {
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.overtimeWorked = overtimeWorked;
    }
}
