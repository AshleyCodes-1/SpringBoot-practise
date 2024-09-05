package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDao;
import com.dto.EmployeeDTO;
import com.entity.EmployeeEntity;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public EmployeeDTO authenticate(String emailId, String password) {
		EmployeeEntity employeeEntity = employeeDao.authenticate(emailId, password);
		EmployeeDTO employeeDTO = new EmployeeDTO();
		BeanUtils.copyProperties(employeeEntity, employeeDTO);
		
		return employeeDTO;
	}
	
	//fetch all the records
	@Override
	public List<EmployeeDTO> getAllEmployee() {
		List<EmployeeDTO> employeeDTO=new ArrayList<>();
			                 //employeeDTO is now collection of numbers of dto objects
		List<EmployeeEntity> employeeEntity=employeeDao.getAllEmployee();
			
		for(EmployeeEntity   tempa:employeeEntity) {
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(tempa, dto);
			employeeDTO.add(dto);//here now dto is an object
		}	
		return employeeDTO;
	}

	//registration operation
	@Override
	public String saveEmployee(EmployeeDTO employeeDTO) {
		//daoLayer   EmployeeEntity  employeeEntity
		EmployeeEntity  employeeEntity=new EmployeeEntity();
		//copy the data elements from employeeDTO to employeeEntity so that daoLayer can read it
		BeanUtils.copyProperties(employeeDTO, employeeEntity);
			
		return employeeDao.saveEmployee(employeeEntity);  // "record inserted"      or "record not inserted"
	
	}

	//delete operation
	@Override
	public void deleteEmployee(String employeeId) {
		employeeDao.deleteEmployee(employeeId);
			
	}

	//update operation - (tier1)
	@Override
	public EmployeeDTO getEmployee(int employeeId) {
		EmployeeEntity employeeEntity=employeeDao.getEmployee(employeeId);
		EmployeeDTO employeeDTO=new EmployeeDTO();
			    
		BeanUtils.copyProperties(employeeEntity, employeeDTO); 
			    
		return employeeDTO;
	}

	//update operation - (tier-2)
	@Override
	public String updateEmployee(EmployeeDTO employeeDTO) {
		EmployeeEntity  employeeEntity=new EmployeeEntity();
		BeanUtils.copyProperties(employeeDTO,employeeEntity);
		String message=employeeDao.updateEmployee(employeeEntity);
		return message;
	}
}
