package q1_MariaNascimento;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<Employee> employees;
    private List<Vehicle> vehicles; 

    public Company(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
        this.vehicles = new ArrayList<>();
    }

    public void CompName(){
        System.out.println("Comapny name: " + this.name);
    }
    public void Hire(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void Employs(Employee employee) {
        employees.add(employee);
    }
}

class Vehicle {
    private String registrationNumber;

    public Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String RegNumber(){
        return this.registrationNumber;
    }
}

class Truck extends Vehicle {
    private int mass;

    public Truck(String registrationNumber, int mass) {
        super(registrationNumber);
        this.mass = mass;
    }
}

class Car extends Vehicle {
    private String transmission;

    public Car(String registrationNumber, String transmission) {
        super(registrationNumber);
        this.transmission = transmission;
    }
}

class Employee {
    private String name;
    private List<Vehicle> vehicles;

    public Employee(String name) {
        this.name = name;
        this.vehicles = new ArrayList<>();
    }

    public void EmploName() {
        System.out.println("Employee Name: " + this.name);
    }

    public void Drives(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void WhatDrive() {
        System.out.print("Employee Vehicles: ");
        for (Vehicle vehicle : vehicles) {
            System.out.print(vehicle.RegNumber() + " ");
        }
        System.out.println();
    }
}
