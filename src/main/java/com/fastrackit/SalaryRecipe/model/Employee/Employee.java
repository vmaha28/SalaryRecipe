package com.fastrackit.SalaryRecipe.model.Employee;

import com.fastrackit.SalaryRecipe.model.Salary.Salary;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;

@Entity
@Setter
@Getter
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
    private Integer hoursWorked;
    @Column
    private Integer overtimeWorked;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "post", fetch = FetchType.LAZY)
    @LazyToOne(LazyToOneOption.NO_PROXY)
//    @JoinTable(name = "emp_salary",
//            joinColumns =
//                    { @JoinColumn(name = "employee_id", referencedColumnName = "id") },
//            inverseJoinColumns =
//                    { @JoinColumn(name = "salary_id", referencedColumnName = "id") })
    private Salary salary;

    public Employee(String name, Integer hoursWorked, Integer overtimeWorked) {
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.overtimeWorked = overtimeWorked;
    }
}
