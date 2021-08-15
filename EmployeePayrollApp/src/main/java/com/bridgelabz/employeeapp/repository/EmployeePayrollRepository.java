package com.bridgelabz.employeeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.employeeapp.model.EmployeePayrollData;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer>{

}
