package com.bridgelabz.employeeapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeeapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeeapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeeapp.model.EmployeePayrollData;
import com.bridgelabz.employeeapp.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	private EmployeePayrollRepository employeeRepository;
	
	/**
	 * This method return list of employee data.
	 */
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {		
		return employeeRepository.findAll();
	}
	
	/**
	 * This method return employee data by Id.
	 */
	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return employeeRepository
				.findById(empId)
				.orElseThrow(() -> new EmployeePayrollException("Employee With employeeId "+empId +"does not Exists..!!"));
	}

	/**
	 * Method to add Employee data.
	 */
	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(empPayrollDTO);
		log.debug("Emp Data: "+empData.toString());
		return employeeRepository.save(empData);
	}

	/**
	 * Method to update Employee data.
	 */
	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		empData.updateEmployeePayrollData(empPayrollDTO);
		return employeeRepository.save(empData); 
	}

	/**
	 * Method to delete Employee data by Id.
	 */
	@Override
	public void deleteEmployeePayrollData(int empId) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		employeeRepository.delete(empData);;
	}

}
