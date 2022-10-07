package com.fastrackit.SalaryRecipe.service;

import com.fastrackit.SalaryRecipe.model.Employee;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@Component
public class EmployeeReader implements EmployeeProvider {

    private final List<Employee> employees;

    public EmployeeReader() throws URISyntaxException {
        this.employees = readEmployes();
    }


    private Employee lineToEmployee (String line) {
        String[] tokens = line.split("\\|");
        return new Employee(tokens[0],Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
    }
    private List<Employee> readEmployes() throws URISyntaxException {
        try {
            URI path = Objects.requireNonNull(getClass().getClassLoader().getResource("employess.txt")).toURI();
            return Files.lines(Path.of(path))
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
