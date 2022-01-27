package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryStub implements EmployeeRepository {

    private final List<Employee> list = new ArrayList<>();

    public EmployeeRepositoryStub() {
        list.add(new Employee("test", 1));
        list.add(new Employee("test2", 2));
    }

    @Override
    public List<Employee> findAll() {
        return List.copyOf(list);
    }

    @Override
    public Employee save(Employee e) {
        return e;
    }
}
