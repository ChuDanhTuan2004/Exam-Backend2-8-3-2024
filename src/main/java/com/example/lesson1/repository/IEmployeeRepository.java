package com.example.lesson1.repository;

import com.example.lesson1.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findAllByNameContaining(String name);
    Page<Employee> findAllByAddressContaining(String address);
    Page<Employee> findAllByAgeContaining (int age);
    Page<Employee> findAll(Pageable pageable);
}
