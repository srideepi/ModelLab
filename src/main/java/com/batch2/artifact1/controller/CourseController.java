package com.batch2.artifact1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.batch2.artifact1.domain.Accountant;
import com.batch2.artifact1.service.AccountantService;

@Controller
public class CourseController {
    @Autowired
    private AccountantService service;

    @GetMapping("/welcome")
    public String viewHomePage(Model model) {
        model.addAttribute("listaccount", service.listAll());
        return "welcome";
    }

    @GetMapping("/new")
    public String addAccountForm(Model model) {
        model.addAttribute("account", new Accountant());
        return "new";
    }

    @PostMapping("/save")
    public String saveAccount(@ModelAttribute Accountant account) {
        service.save(account);
        return "redirect:/welcome";
    }

    @GetMapping("/edit/{no}")
    public String showEditForm(@PathVariable long no, Model model) {
        model.addAttribute("account", service.get(no));
        return "new";
    }

    @GetMapping("/delete/{no}")
    public String deleteAccount(@PathVariable long no) {
        service.delete(no);
        return "redirect:/welcome";
    }

    @GetMapping("/logout")
    public String logout() {
        return "login";
    }
}
