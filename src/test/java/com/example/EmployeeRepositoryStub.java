package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryStub implements EmployeeRepository {
    @Override
    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("test", 1));
        list.add(null);
        return list;
    }

    @Override
    public Employee save(Employee e) {
        return e;
    }
}
