package com.employee.testscotia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.testscotia.dto.EmpDeptSalaryDto;
import com.employee.testscotia.models.Employee;
import com.employee.testscotia.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeSearchController {
    
    @Autowired
    EmployeeService employeeService;
    
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(
    			@RequestParam(defaultValue="0") Integer pageNum,
    			@RequestParam(defaultValue="10") Integer pageSize) 
    {
    	List<Employee> employees = employeeService.getAllEmployee(pageNum, pageSize);
    	
    	if (!employees.isEmpty()) {
    		return ResponseEntity.status(HttpStatus.FOUND).body(employees);
		}
    	//return new ResponseEntity<List<Employee>>(employees, new HttpHeaders(), HttpStatus.OK);
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
    }
   
    @GetMapping("/employees/{id}")
    public ResponseEntity<List<EmpDeptSalaryDto>> getEmployeeById(@Validated @PathVariable(value = "id") Integer employeeId)
            throws Exception {
    	
    	List<EmpDeptSalaryDto> employee = employeeService.getEmployeeById(employeeId);
        if (!employee.isEmpty()) {
        	 return ResponseEntity.status(HttpStatus.FOUND).body(employee);
		}               
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
