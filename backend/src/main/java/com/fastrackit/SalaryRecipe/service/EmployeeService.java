package com.fastrackit.SalaryRecipe.service;

import com.fastrackit.SalaryRecipe.exception.ResourceNotFoundException;
import com.fastrackit.SalaryRecipe.model.Employee;
import com.fastrackit.SalaryRecipe.repository.EmployeeRepository;
import com.fastrackit.SalaryRecipe.repository.specifications.EmployeeSpecification;
import com.fastrackit.SalaryRecipe.repository.specifications.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final SalaryService salaryService;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, SalaryService salaryService) {
        this.employeeRepository = employeeRepository;
        this.salaryService = salaryService;
    }




    public List<Employee> getAllEmployee() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer employeeId) {
        Optional<Employee> result = employeeRepository.findById(employeeId);
        if (result.isEmpty()) {
            throw new ResourceNotFoundException("Invalid Employee ID");
        }
        return result.get();
    }

    public Page<Employee> findAll(int pageIndex, int pageSize) {
        Pageable firstPageWithTwoElements = PageRequest.of(pageIndex, pageSize);
        Page<Employee> pagedResult = employeeRepository.findAll(firstPageWithTwoElements);

        return pagedResult;
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    public Employee putEmployee(Integer employeeId, Employee employee) {
//        employee.setId(employeeId);
        employee.setSalary(salaryService.getSalaryFromEmployee(employeeId));
        return employeeRepository.save(employee);
    }

    public long countTotalEmployees() {
        return employeeRepository.count();
    }


    public List<Employee> findByName(String keyword) {
        EmployeeSpecification spec =
                new EmployeeSpecification(SearchCriteria.builder().operation(":").key("name").value(keyword).build());


        return employeeRepository.findAll(spec);
    }


    public List<Employee> findByNameAndSurname(String name, String surname) {
        EmployeeSpecification spec1 =
                new EmployeeSpecification(SearchCriteria.builder().operation(":").key("name").value(name).build());
        EmployeeSpecification spec2 =
                new EmployeeSpecification(SearchCriteria.builder().operation(":").key("surname").value(surname).build());

        return employeeRepository.findAll(Specification.where(spec1).and(spec2));

    }

    public List<Employee> searchByMultipleFields(String keyword) {
        EmployeeSpecification spec1 =
                new EmployeeSpecification(SearchCriteria.builder().operation(":").key("name").value(keyword).build());
        EmployeeSpecification spec2 =
                new EmployeeSpecification(SearchCriteria.builder().operation(":").key("surname").value(keyword).build());

        return employeeRepository.findAll(Specification.where(spec1).or(spec2));

    }

    public Page<Employee> searchByMultipleFieldsOptim(String keyword, int pageNumber, int pageSize) {
        EmployeeSpecification spec1 =
                new EmployeeSpecification(SearchCriteria.builder().operation(":").key("name").value(keyword).build());
        EmployeeSpecification spec2 =
                new EmployeeSpecification(SearchCriteria.builder().operation(":").key("surname").value(keyword).build());

        return employeeRepository.findAll(Specification.where(spec1).or(spec2), PageRequest.of(pageNumber, pageSize));

    }



//    public void editEmployee(Integer employeeId, Employee employee) {
//
//        feedback.setId(feedbackId);
//        feedback.setCourse(findFeedback(feedbackId).getCourse());
//        feedback.setAuthor(userService.findUser(userId));
//        feedbackRepository.save(feedback);
//    }


}
