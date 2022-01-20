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
}