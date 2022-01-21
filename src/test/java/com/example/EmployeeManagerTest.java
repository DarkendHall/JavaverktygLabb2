package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployeeManagerTest {

    @Test
    @DisplayName("payEmployee should return number of employees that have been paid")
    void payEmployeeShouldReturnNrOfEmployeesPaid() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        BankService bankService = mock(BankService.class);
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);
        when(employeeRepository.findAll()).thenReturn(
                List.of(new Employee("Marcus", 100), new Employee("Omar", 99)));

        var result = employeeManager.payEmployees();

        assertThat(result).isEqualTo(2);
    }

}