package com.employee.testscotia.dto;

import java.io.Serializable;

public class EmpDeptSalaryDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int empNo;
	private String first_name;
	private String lastName;
	private String deptName;
	private int salary;
	
	public EmpDeptSalaryDto() {
		
	}

	public EmpDeptSalaryDto(int empNo, String first_name, String lastName, String deptName, int salary) {
		this.empNo = empNo;
		this.first_name = first_name;
		this.lastName = lastName;
		this.deptName = deptName;
		this.salary = salary;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmpDeptSalaryDto [empNo=" + empNo + ", first_name=" + first_name + ", lastName=" + lastName
				+ ", deptName=" + deptName + ", salary=" + salary + "]";
	}
	

}
