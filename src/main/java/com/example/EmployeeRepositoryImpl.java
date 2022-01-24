package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final List<Employee> employees;

    public EmployeeRepositoryImpl() {
        this.employees = new ArrayList<>();
    }

    public EmployeeRepositoryImpl(List<Employee> employees) {
        this.employees = new ArrayList<>(employees);
    }

    @Override
    public List<Employee> findAll() {
        return List.copyOf(employees);
    }

    @Override
    public Employee save(Employee e) {
        employees.stream()
                .filter(employee -> employee.getId()
                        .equals(e.getId()))
                .findFirst()
                .ifPresent(this::removeFromList);
        employees.add(e);

        return e;
    }

    private void removeFromList(Employee e) {
        employees.remove(e);
    }
}
