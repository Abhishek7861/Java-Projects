package com.Abhisheksingh.SpringBoot.Tutorial.service;

import com.Abhisheksingh.SpringBoot.Tutorial.entity.Department;
import com.Abhisheksingh.SpringBoot.Tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

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
                .departmentAddress("Kanpur").
                departmentId(1L).
                departmentCode("IT01")
                .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    @Disabled
    @DisplayName("Get Data Function")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String department = "IT";
        Department found = departmentService.fetchDepartmentByName(department);
        System.out.println(found.getDepartmentName()+" : "+department);
        assertEquals(department,found.getDepartmentName());
    }
}