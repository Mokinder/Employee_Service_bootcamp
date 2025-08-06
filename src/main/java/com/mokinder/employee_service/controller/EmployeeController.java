package com.mokinder.employee_service.controller;


import com.mokinder.employee_service.model.Employee;
import com.mokinder.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/fetch/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.getByEmployeeId(id);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployee(){
        return employeeService.getAll();
    }

    @GetMapping("/get-by-dept/{id}")
    public List<Employee> getEmployeeByDepartment(@PathVariable Long id){
        return employeeService.getEmployeeByDepartment(id);
    }


}
