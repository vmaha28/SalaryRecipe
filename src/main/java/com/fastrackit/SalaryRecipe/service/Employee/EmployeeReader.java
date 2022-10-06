package com.fastrackit.SalaryRecipe.service.Employee;

import com.fastrackit.SalaryRecipe.model.Employee.Employee;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class EmployeeReader implements EmployeeProvider {

    private final List<Employee> employees;

    public EmployeeReader() {
        this.employees = readEmployes();
    }


    private Employee lineToEmployee (String line) {
        String[] tokens = line.split("\\|");
        return new Employee(tokens[0],Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
    }
    private List<Employee> readEmployes() {
        try {
            return Files.lines(Path.of("SalaryRecipe/src/main/resources/employess.txt"))
                    .map(line -> lineToEmployee(line))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> getEmployee() {
        return employees;
    }
}
