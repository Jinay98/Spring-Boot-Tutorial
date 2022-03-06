package com.dailycodebuffer.springboot.tutorial.service;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Ahmedabad")
                .departmentCode("IT-06")
                .departmentId(1L)
                .build();

        when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on valid department name")
    public void whenValidDepartmentName_thenDepartmentIsFound() {
        String departmentName = "IT";
        departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
}