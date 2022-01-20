package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeRepositoryImplTest {

    EmployeeRepository employeeRepository;

    @Test
    @DisplayName("findAll should return a list")
    void findAllShouldReturnAList() {
        employeeRepository = new EmployeeRepositoryImpl();

        var result = employeeRepository.findAll();

        assertThat(result).isInstanceOf(List.class);
    }

    @Test
    @DisplayName("save should add provided employee to the list of employees")
    void saveShouldAddEmployeeToList() {
        employeeRepository = new EmployeeRepositoryImpl();

        Employee employee = new Employee("test", 1);
        employeeRepository.save(employee);

        var result = employeeRepository.findAll();

        assertThat(result).contains(employee);
    }
}