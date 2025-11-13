package com.demo.s4c2exam.repo;

import com.demo.s4c2exam.model.Staffs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staffs, Long> {
}
