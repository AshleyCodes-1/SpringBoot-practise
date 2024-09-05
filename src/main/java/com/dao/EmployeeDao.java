package com.dao;

import java.util.List;

import com.entity.EmployeeEntity;

public interface EmployeeDao {

	public EmployeeEntity authenticate(String emailId, String password);

	public List<EmployeeEntity> getAllEmployee();

	public String saveEmployee(EmployeeEntity employeeEntity);

	public void deleteEmployee(String employeeId);

	public EmployeeEntity getEmployee(int employeeId);

	public String updateEmployee(EmployeeEntity employeeEntity);

}
