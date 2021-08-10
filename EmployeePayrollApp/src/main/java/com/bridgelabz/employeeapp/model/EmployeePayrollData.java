package com.bridgelabz.employeeapp.model;

import com.bridgelabz.employeeapp.dto.EmployeePayrollDTO;

import lombok.Data;

@Data
public class EmployeePayrollData {
	private int employeeId;
	private String name;
	private long salary;
	
	public EmployeePayrollData() {}
	
	public EmployeePayrollData(int employeeId, EmployeePayrollDTO empPayrollDTO) {
		this.employeeId = employeeId;
		this.name = empPayrollDTO.name;
		this.salary = empPayrollDTO.salary;
	}
}
