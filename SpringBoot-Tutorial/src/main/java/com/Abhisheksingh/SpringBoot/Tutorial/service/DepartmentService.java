package com.Abhisheksingh.SpringBoot.Tutorial.service;

import com.Abhisheksingh.SpringBoot.Tutorial.Error.DepartmentNotFoundException;
import com.Abhisheksingh.SpringBoot.Tutorial.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
