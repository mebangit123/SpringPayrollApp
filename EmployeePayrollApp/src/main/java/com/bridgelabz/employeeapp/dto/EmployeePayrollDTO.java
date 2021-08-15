package com.bridgelabz.employeeapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.ToString;

@ToString
public class EmployeePayrollDTO {
	
	@Pattern(message = "Employee name is Invalid", regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$")
	public String name;
	
	@Min(value =500, message = "Min Wage should be more than 500")
	public long salary;
	 
	@Pattern(regexp = "male|female",message = "Gender needs to be male or female")
	public String gender;
	
	@JsonFormat(pattern="dd MMM yyyy")
	@NotNull
	@PastOrPresent(message = "StartDate should be past or today's date")
	public LocalDate startDate;
	
	@NotBlank(message = "Note cannot be Empty")
	public String note;
	
	@NotBlank(message = "ProfilePic cannot be Empty")
	public String profilePic;
	
	@NotNull(message = "Department should not be Empty")
	public List<String> department;
}
