package com.employee.testscotia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.employee.testscotia.dto.EmpDeptSalaryDto;
import com.employee.testscotia.exception.DataNotFoundExceprion;
import com.employee.testscotia.models.Employee;
import com.employee.testscotia.repo.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployee(Integer pageNum,Integer pageSize) {
    	Pageable paging = PageRequest.of(pageNum, pageSize);
    	Page<Employee> pageResult =  employeeRepository.findAll(paging);
    	
    	if (pageResult.isEmpty() || pageResult == null) {
			throw new DataNotFoundExceprion("Employees details not available. Please try again later");
		}
    	
    	return pageResult.getContent();
    }
	
	public List<EmpDeptSalaryDto> getEmployeeById(Integer id) {
		List<EmpDeptSalaryDto> employee = employeeRepository.findEmpDeptSalaryById(id);
		if (employee.isEmpty() || employee == null) {
			throw new DataNotFoundExceprion("Employee with id " + id + " not found");
		}
		return employee;
	}

}
