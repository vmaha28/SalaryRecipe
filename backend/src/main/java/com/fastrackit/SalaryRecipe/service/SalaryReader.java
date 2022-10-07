package com.fastrackit.SalaryRecipe.service;

import com.fastrackit.SalaryRecipe.model.Salary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

@Component
public class SalaryReader implements SalaryProvider {

    private final List<Salary> salaries;

    public SalaryReader(List<Salary> salaries) throws URISyntaxException {
        this.salaries = readSalaries();
    }


    @Override
    public List<Salary> getSalary() {
        return salaries;
    }

    private Salary lineToEmployee(String line) {
        String[] tokens = line.split("\\|");
        return new Salary(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
    }
    private List<Salary> readSalaries() throws URISyntaxException {
        try {
            URI path = Objects.requireNonNull(getClass().getClassLoader().getResource("salaries.txt")).toURI();
            return Files.lines(Path.of(path))
                    .map(line -> lineToEmployee(line))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
