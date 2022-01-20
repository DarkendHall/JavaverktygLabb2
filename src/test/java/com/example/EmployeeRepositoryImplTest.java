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

    @Test
    @DisplayName("You should be able to pass a list into the constructor")
    void listInConstructor() {
        Employee employee = new Employee("test", 1);
        employeeRepository = new EmployeeRepositoryImpl(List.of(employee));

        var result = employeeRepository.findAll();

        assertThat(result).contains(employee);
    }

    @Test
    @DisplayName("save should add to list when using constructor that takes a list as argument")
    void saveOnListWhenInitializedWithConstructorArgument() {
        Employee employee = new Employee("test", 1);
        Employee employee1 = new Employee("test1", 1);
        employeeRepository = new EmployeeRepositoryImpl(List.of(employee));

        employeeRepository.save(employee1);

        var result = employeeRepository.findAll();

        assertThat(result).containsExactly(employee, employee1);
    }
}