package com.bridgelabz.employeeapp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.bridgelabz.employeeapp.dto.EmployeePayrollDTO;

import lombok.Data;

@Entity
@Table(name = "employee_payroll")
@Data
public class EmployeePayrollData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employeeId;
	private String name;
	private long salary;
	private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;
	
	@ElementCollection
	@CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name ="id"))
	@Column(name = "department")
	private List<String> department;
	
	public EmployeePayrollData() {}
	
	public EmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		this.updateEmployeePayrollData(empPayrollDTO);
	}

	public void updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		this.name = empPayrollDTO.name;
		this.salary = empPayrollDTO.salary;
		this.gender = empPayrollDTO.gender;
		this.startDate = empPayrollDTO.startDate;
		this.note = empPayrollDTO.note;
		this.profilePic = empPayrollDTO.profilePic;
		this.department = empPayrollDTO.department;
	}
}
