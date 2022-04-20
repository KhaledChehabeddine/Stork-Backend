package com.recruiting.backend.service;

import com.recruiting.backend.exception.UserNotFoundException;
import com.recruiting.backend.model.Candidate;
import com.recruiting.backend.model.Employee;
import com.recruiting.backend.repo.CandidateRepo;
import com.recruiting.backend.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) { this.employeeRepo = employeeRepo; }

    public Employee addEmployee(Employee employee) { return employeeRepo.save(employee); }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Employee updateEmployee(Employee employee) { return employeeRepo.save(employee); }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("Employee with id: " + id + " is not found."));
    }

    public void deleteEmployee(Long id) { employeeRepo.deleteEmployeeById(id); }

}
