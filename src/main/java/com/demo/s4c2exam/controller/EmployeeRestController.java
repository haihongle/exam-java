package com.demo.s4c2exam.controller;

import com.demo.s4c2exam.model.Employee;
import com.demo.s4c2exam.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    private final EmployeeService service;

    public EmployeeRestController(EmployeeService service) {
        this.service = service;
    }

    // 1. getEmployees -> GET /api/employees
    @GetMapping
    public List<Employee> getEmployees() {
        return service.getAll();
    }

    // 2. addEmployees -> POST /api/employees
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee created = service.add(employee);
        return ResponseEntity.ok(created);
    }

    // 3. updateEmployee -> PUT /api/employees/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return service.update(id, employee)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
