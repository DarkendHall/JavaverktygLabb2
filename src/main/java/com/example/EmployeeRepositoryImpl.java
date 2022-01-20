package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    List<Employee> employees;

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
        if (!employees.contains(e))
            if (employees.stream()
                    .noneMatch(emp -> Objects.equals(emp.getId(), e.getId())))
                employees.add(e);
        return e;
    }
}
