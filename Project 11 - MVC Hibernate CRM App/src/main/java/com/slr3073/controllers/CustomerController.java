package com.slr3073.controllers;

import com.slr3073.entities.Customer;
import com.slr3073.repositories.CustomerDAO;
import com.slr3073.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public String displayCustomerList(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customer-list";
    }

    @GetMapping("/saveCustomerForm")
    public String displaySaveForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "saveCustomerForm";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @RequestMapping("/*")
    public String redirect() {
        return "redirect:".concat("customers");
    }
}