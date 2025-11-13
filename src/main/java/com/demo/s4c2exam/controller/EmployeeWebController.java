package com.demo.s4c2exam.controller;

import com.demo.s4c2exam.model.Employee;
import com.demo.s4c2exam.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeWebController {
    private final EmployeeService svc;

    public EmployeeWebController(EmployeeService svc) {
        this.svc = svc;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("employees", svc.getAll());
        return "employees/list"; // src/main/resources/templates/employees/list.html
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/form"; // form for create
    }

    @PostMapping
    public String save(@ModelAttribute Employee employee) {
        svc.add(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        svc.findById(id).ifPresent(e -> model.addAttribute("employee", e));
        return "employees/form";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Employee employee) {
        svc.update(id, employee);
        return "redirect:/employees";
    }
}
