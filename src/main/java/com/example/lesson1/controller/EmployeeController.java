package com.example.lesson1.controller;

import com.example.lesson1.model.Employee;
import com.example.lesson1.model.PageWeb;
import com.example.lesson1.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    IEmployeeRepository employeeRepository;

//    @GetMapping("")
//    public ResponseEntity findAll(@RequestBody PageWeb pageWeb) {
//        Pageable pageable = PageRequest.of(pageWeb.getPage(), pageWeb.getSize(), Sort.by("id"));
//        Page<Employee> employees = employeeRepository.findAll(pageable);
//        List<Employee> employeeList = new ArrayList<>();
//        for ( Employee employee : employees){
//            employeeList.add(employee);
//        }
//        return new ResponseEntity(employeeList, HttpStatus.OK);
//    }

    @GetMapping("")
    public ResponseEntity findAll() {
        return new ResponseEntity(employeeRepository.findAll(), HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity save(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity("error with validate!", HttpStatus.BAD_REQUEST);
        }
        employeeRepository.save(employee);
        return new ResponseEntity("Created", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@Valid @PathVariable Long id, @RequestBody Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity("error with validate!", HttpStatus.BAD_REQUEST);
        }
        employee.setId(id);
        employeeRepository.save(employee);
        return new ResponseEntity("Updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return new ResponseEntity("Deleted", HttpStatus.OK);
    }

    @GetMapping("/findName")
    public ResponseEntity findName(@RequestParam String name) {
        return new ResponseEntity(employeeRepository.findAllByNameContaining(name), HttpStatus.OK);
    }

    @GetMapping("/findAddress")
    public ResponseEntity findAddress(@RequestParam String address) {
        return new ResponseEntity(employeeRepository.findAllByAddressContaining(address), HttpStatus.OK);
    }

    @GetMapping("/findAge")
    public ResponseEntity findAge(@RequestParam int age) {
        return new ResponseEntity(employeeRepository.findAllByAgeContaining(age), HttpStatus.OK);
    }
}
