package com.example.lesson1.repository;

import com.example.lesson1.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByNameContaining(String name);
    List<Employee> findAllByAddressContaining(String address);
    List<Employee> findAllByAgeContaining (int age);
//    Page<Employee> findAll(Pageable pageable);
}
