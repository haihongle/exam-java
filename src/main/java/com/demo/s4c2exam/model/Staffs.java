package com.demo.s4c2exam.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Staffs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double salary;

    public Staffs() {}

    public Staffs(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
}
