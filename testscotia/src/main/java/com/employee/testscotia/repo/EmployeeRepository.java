package com.employee.testscotia.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.testscotia.dto.EmpDeptSalaryDto;
import com.employee.testscotia.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Integer>{
	
	@Query("SELECT new com.employee.testscotia.dto.EmpDeptSalaryDto(e.empNo, e.firstName, e.lastName, dept.deptName, s.salary)"
			+ " FROM Employee e" 
			+ " INNER JOIN DeptEmp d ON e.empNo = d.employee AND d.toDate = (SELECT MAX(x.toDate) FROM DeptEmp x WHERE x.employee = e.empNo)" 
			+ " INNER JOIN Department dept ON d.department = dept.deptNo" 
			+ " INNER JOIN Salary s ON e.empNo = s.employee"
			+ " WHERE e.empNo = ?1")
	List<EmpDeptSalaryDto> findEmpDeptSalaryById(Integer id);
}
