package com.demo.s4c2exam.service;

import com.demo.s4c2exam.model.Staffs;
import com.demo.s4c2exam.repo.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {
    private final StaffRepository repo;

    public StaffService(StaffRepository repo) {
        this.repo = repo;
    }

    public List<Staffs> getAll() {
        return repo.findAll();
    }

    public Staffs add(Staffs e) {
        e.setId(null);
        return repo.save(e);
    }

    public Optional<Staffs> update(Long id, Staffs e) {
        return repo.findById(id).map(existing -> {
            existing.setName(e.getName());
            existing.setSalary(e.getSalary());
            return repo.save(existing);
        });
    }

    public Optional<Staffs> findById(Long id) {
        return repo.findById(id);
    }
}
