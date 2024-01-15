package com.example.test.controller;

import com.example.test.entity.EmployeeEntity;
import com.example.test.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeEntity> findAllEmloyee(){
        return employeeService.findAllEmployee();
    }

    @GetMapping("/{id}")
    public Optional<EmployeeEntity> fingEmployeeById(@PathVariable("id") Long id){
        return employeeService.findById(id);
    }

    @PostMapping
    public EmployeeEntity saveEmployee(@Valid @RequestBody EmployeeEntity employeeEntity){
        return employeeService.saveEmployee(employeeEntity);
    }

    @PutMapping
    public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employeeEntity){
        return employeeService.updateEmployee(employeeEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }
}
