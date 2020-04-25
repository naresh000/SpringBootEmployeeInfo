package com.employee.testscotia.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.testscotia.models.Salary;

public interface SalaryRepository extends JpaRepository <Salary, Integer>{
	List<Salary> findByEmployeeEmpNo(Integer empNo);
}
