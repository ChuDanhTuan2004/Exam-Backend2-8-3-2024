package com.example.lesson2.repository;

import com.example.lesson2.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComputerRepository extends JpaRepository<Computer, Long> {
    List<Computer> findAllByNameContaining(String name);
    List<Computer> findAllByManufacturerContaining(String manufacturer);
    List<Computer> findAllByTypeContaining(String type);
}
