package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeTest {

    @Test
    @DisplayName("getId should return correct ID")
    void getIdEmployee() {
        Employee employee = new Employee("Marcus", 100);

        var result = employee.getId();

        assertThat(result).isEqualTo("Marcus");
    }

    @Test
    @DisplayName("setId should update ID")
    void setIdEmployee() {
        Employee employee = new Employee("Narcus", 100);

        employee.setId("Marcus");

        var result = employee.getId();

        assertThat(result).isEqualTo("Marcus");
    }

    @Test
    @DisplayName("getSalary should return correct salary")
    void getSalaryEmployee() {
        Employee employee = new Employee("Marcus", 100);

        var result = employee.getSalary();

        assertThat(result).isEqualTo(100);
    }

}