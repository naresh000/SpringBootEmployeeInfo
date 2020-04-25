package com.employee.testscotia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.testscotia.models.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {
	
}
