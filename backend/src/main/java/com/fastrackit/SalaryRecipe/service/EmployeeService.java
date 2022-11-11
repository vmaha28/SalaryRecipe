package com.fastrackit.SalaryRecipe.service;

import com.fastrackit.SalaryRecipe.exception.ResourceNotFoundException;
import com.fastrackit.SalaryRecipe.model.Employee;
import com.fastrackit.SalaryRecipe.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final SalaryService salaryService;


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

   public Page<Employee> findAll(int pageIndex, int pageSize){
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

    public long countTotalEmployees(){
        return  employeeRepository.count();
    }


//    public void editEmployee(Integer employeeId, Employee employee) {
//
//        feedback.setId(feedbackId);
//        feedback.setCourse(findFeedback(feedbackId).getCourse());
//        feedback.setAuthor(userService.findUser(userId));
//        feedbackRepository.save(feedback);
//    }


}
