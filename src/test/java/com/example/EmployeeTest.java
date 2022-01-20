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

    @Test
    @DisplayName("setSalary should update salary")
    void setSalaryEmployee() {
        Employee employee = new Employee("Marcus", 100);

        employee.setSalary(101);

        var result = employee.getSalary();

        assertThat(result).isEqualTo(101);
    }

    @Test
    @DisplayName("isPaid should return false by default")
    void isPaidEmployee() {
        Employee employee = new Employee("Marcus", 100);

        var result = employee.isPaid();

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("isPaid should return true after setPaid with value true as argument")
    void setPaidEmployee() {
        Employee employee = new Employee("Marcus", 100);

        employee.setPaid(true);

        var result = employee.isPaid();

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("toString should return correct string")
    void toStringEmployee() {
        Employee employee = new Employee("Marcus", 100);

        var result = employee.toString();

        assertThat(result).isEqualTo("Employee [id=Marcus, salary=100.0]");
    }

}