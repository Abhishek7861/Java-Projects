package com.Abhisheksingh.SpringBoot.Tutorial.repository;

import com.Abhisheksingh.SpringBoot.Tutorial.entity.Department;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("ME")
                .departmentCode("ME-01")
                .departmentAddress("Delhi")
                .build();

        entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment(){
        Department department = departmentRepository.findByDepartmentName("ME");
        System.out.println(department);
        assertEquals(department.getDepartmentName(),"ME");
    }
}