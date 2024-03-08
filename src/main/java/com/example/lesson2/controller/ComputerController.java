package com.example.lesson2.controller;

import com.example.lesson2.model.Computer;
import com.example.lesson2.repository.IComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/computers")
public class ComputerController {
    @Autowired
    IComputerRepository computerRepository;

    @GetMapping("")
    public ResponseEntity findAll() {
        return new ResponseEntity(computerRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity save(@Valid @RequestBody Computer computer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity("error with validate!", HttpStatus.BAD_REQUEST);
        }
        computerRepository.save(computer);
        return new ResponseEntity("Created", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@Valid @PathVariable Long id, @RequestBody Computer computer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity("error with validate!", HttpStatus.BAD_REQUEST);
        }
        computer.setId(id);
        computerRepository.save(computer);
        return new ResponseEntity("Updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        computerRepository.deleteById(id);
        return new ResponseEntity("Deleted", HttpStatus.OK);
    }

    @GetMapping("/findName")
    public ResponseEntity findName(@RequestParam String name) {
        return new ResponseEntity(computerRepository.findAllByNameContaining(name), HttpStatus.OK);
    }

    @GetMapping("/findManufacturer")
    public ResponseEntity findManufacturer(@RequestParam String manufacturer) {
        return new ResponseEntity(computerRepository.findAllByManufacturerContaining(manufacturer), HttpStatus.OK);
    }

    @GetMapping("/findType")
    public ResponseEntity findType(@RequestParam String type) {
        return new ResponseEntity(computerRepository.findAllByTypeContaining(type), HttpStatus.OK);
    }
}
