package com.example.crudsystem.controller;

import com.example.crudsystem.employee.Employee;
import com.example.crudsystem.exceptions.ResourceNotFoundException;
import com.example.crudsystem.repostories.EmployeeRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeRepostory employeeRepostory;

    @Autowired
    public EmployeeController(EmployeeRepostory employeeRepostory) {
        this.employeeRepostory = employeeRepostory;
    }

    @GetMapping
    public List<Employee> getALLEmployees(){
        return  employeeRepostory.findAll();
    }
    @PostMapping
    public   Employee createEmployee(@RequestBody Employee employee){

        return employeeRepostory.save(employee);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "firstname") String firstname){
//        System.out.println((UUID) id
        Employee employee= this.employeeRepostory.findByName(firstname).orElseThrow(()->new ResourceNotFoundException("USer with ID"+id+" does not exist"));
        return ResponseEntity.ok().body(employee);

    }

}
