package com.jack.springboot3_07.controller;

import com.jack.springboot3_07.model.Employee;
import com.jack.springboot3_07.model.EmployeeRepository;
import com.jack.springboot3_07.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
  EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String index(Model model) {
        // First let's create an employee
        Employee employee = new Employee();
        employee.setName("Stephen Bullock");
        employee.setSsn("555-12-1234");

        //Now lets create a laptop
        Laptop laptop = new Laptop();
        laptop.setBrand("Dell");
        laptop.setModel("Latitude XL");

        // Add laptop to the employee
        employee.setLaptop(laptop);
        //Save employee to the database
        employeeRepository.save(employee);
//        Grab all the emplyeees from the database and send them to the template

        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }
}