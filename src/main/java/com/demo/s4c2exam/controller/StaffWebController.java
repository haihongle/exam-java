package com.demo.s4c2exam.controller;

import com.demo.s4c2exam.model.Staffs;
import com.demo.s4c2exam.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class StaffWebController {
    private final StaffService svc;

    public StaffWebController(StaffService svc) {
        this.svc = svc;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("employees", svc.getAll());
        return "employees/list"; // src/main/resources/templates/employees/list.html
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("employee", new Staffs());
        return "employees/form"; // form for create
    }

    @PostMapping
    public String save(@ModelAttribute Staffs staffs) {
        svc.add(staffs);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        svc.findById(id).ifPresent(e -> model.addAttribute("employee", e));
        return "employees/form";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Staffs staffs) {
        svc.update(id, staffs);
        return "redirect:/employees";
    }
}
