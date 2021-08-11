package com.bridgelabz.employeeapp.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class EmployeePayrollDTO {
	
	@Pattern(message = "Employee name is Invalid", regexp = "^[A-Z]{1}[a-zA-Z\\s{2,}$")
	 public String name;
	
	@Min(value =500, message = "Min Wage should be more than 500")
	 public long salary;
	 
	public EmployeePayrollDTO(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}
}
