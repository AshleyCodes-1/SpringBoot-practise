package com.service;

import java.util.List;

import com.dto.EmployeeDTO;

public interface EmployeeService {
	
	public EmployeeDTO authenticate(String emailId, String password);

	public List<EmployeeDTO> getAllEmployee();

	public String saveEmployee(EmployeeDTO employeeDTO);

	public void deleteEmployee(String employeeId);

	public EmployeeDTO getEmployee(int employeeId);

	public String updateEmployee(EmployeeDTO employeeDTO);

}
