package com.demo.s4c2exam.controller;

import com.demo.s4c2exam.model.Staffs;
import com.demo.s4c2exam.service.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class StaffRestController {
    private final StaffService service;

    public StaffRestController(StaffService service) {
        this.service = service;
    }

    // 1. getEmployees -> GET /api/employees
    @GetMapping
    public List<Staffs> getEmployees() {
        return service.getAll();
    }

    // 2. addEmployees -> POST /api/employees
    @PostMapping
    public ResponseEntity<Staffs> addEmployee(@RequestBody Staffs staffs) {
        Staffs created = service.add(staffs);
        return ResponseEntity.ok(created);
    }

    // 3. updateEmployee -> PUT /api/employees/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Staffs> updateEmployee(@PathVariable Long id, @RequestBody Staffs staffs) {
        return service.update(id, staffs)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
