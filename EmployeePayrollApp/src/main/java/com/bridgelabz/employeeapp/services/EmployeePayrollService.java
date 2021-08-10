package com.bridgelabz.employeeapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeeapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeeapp.model.EmployeePayrollData;


@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
	
	/**
	 * This method return list of employee data.
	 */
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {		
		return employeePayrollList;
	}
	
	/**
	 * This method return employee data by Id.
	 */
	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return employeePayrollList.get(empId-1);
	}

	/**
	 * Method to add Employee data.
	 */
	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1,empPayrollDTO);
		employeePayrollList.add(empData);
		return empData;
	}

	/**
	 * Method to update Employee data.
	 */
	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		empData.setName(empPayrollDTO.name);
		empData.setSalary(empPayrollDTO.salary);
		employeePayrollList.set(empId-1, empData);
		return empData; 
	}

	/**
	 * Method to delete Employee data by Id.
	 */
	@Override
	public void deleteEmployeePayrollData(int empId) {
		employeePayrollList.remove(empId-1);
	}

}
