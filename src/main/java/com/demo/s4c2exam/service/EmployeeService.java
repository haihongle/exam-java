package com.demo.s4c2exam.service;

import com.demo.s4c2exam.model.Employee;
import com.demo.s4c2exam.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee add(Employee e) {
        e.setId(null);
        return repo.save(e);
    }

    public Optional<Employee> update(Long id, Employee e) {
        return repo.findById(id).map(existing -> {
            existing.setName(e.getName());
            existing.setSalary(e.getSalary());
            return repo.save(existing);
        });
    }

    public Optional<Employee> findById(Long id) {
        return repo.findById(id);
    }
}
