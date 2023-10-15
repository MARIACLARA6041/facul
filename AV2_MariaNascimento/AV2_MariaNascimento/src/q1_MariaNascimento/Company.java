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

    public void hire(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void employs(Employee employee) {
        employees.add(employee);
    }
}

class Vehicle {
    private String registrationNumber;

    public Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
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

    public void drives(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
}
