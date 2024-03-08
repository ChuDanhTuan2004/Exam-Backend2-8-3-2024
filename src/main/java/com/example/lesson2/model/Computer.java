package com.example.lesson2.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "computers")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    private String manufacturer;
    private String type;
    @NotEmpty
    private String OS;
    @NotEmpty
    private String CPU;
    @Min(8)
    private String RAM;
    @Min(64)
    private String ROM;
    private String RTX;

    public Computer() {
    }

    public Computer(Long id, String name, String manufacturer, String type, String OS, String CPU, String RAM, String ROM, String RTX) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
        this.OS = OS;
        this.CPU = CPU;
        this.RAM = RAM;
        this.ROM = ROM;
        this.RTX = RTX;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getROM() {
        return ROM;
    }

    public void setROM(String ROM) {
        this.ROM = ROM;
    }

    public String getRTX() {
        return RTX;
    }

    public void setRTX(String RTX) {
        this.RTX = RTX;
    }
}
