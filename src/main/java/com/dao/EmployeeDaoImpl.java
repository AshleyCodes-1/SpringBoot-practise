package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.entity.EmployeeEntity;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public EmployeeEntity authenticate(String emailId, String password) {
		EmployeeEntity employeeEntity = null;
		String sql = "select * from employee where emailId=? and password=?";
		Object[] data = { emailId, password };

		try {
			employeeEntity = (EmployeeEntity) jdbcTemplate.queryForObject(sql, data, new BeanPropertyRowMapper<>(EmployeeEntity.class));
		} catch (Exception e) {

		}
		return employeeEntity; // null or not_Null
	}
	
	//fetch all the records from employee table
	
	@Override
	public List<EmployeeEntity> getAllEmployee() {
		String sql="select * from employee";
			List<EmployeeEntity>  employee=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(EmployeeEntity.class) );
			
			
			return employee; //collection of employeeEntity(means numbers of several objects)
	}	

		
	//registering a candidate
	@Override                                  //5
	public String saveEmployee(EmployeeEntity employeeEntity) {
			
		Object[] data=new Object[] {employeeEntity.getEmployeeId(),employeeEntity.getEmployeeName(),employeeEntity.getSalary(),employeeEntity.getEmailId(),employeeEntity.getPassword()};
			            
			                                 //executeUpdate()---->int value                                         executeQuery()---->instance of ResultSet
		int rowCount=jdbcTemplate.update("insert into employee (employeeId,employeeName,salary,emailId,password)values(?,?,?,?,?)",data);
		return rowCount > 0 ? "One record inserted" : "Record not inserted";
	}

		
	//delete a record
	@Override
	public void deleteEmployee(String employeeId) {
			
		jdbcTemplate.update("delete from employee where employeeid=?",employeeId);
	}

	//update record (tier-1)
	@Override
	public EmployeeEntity getEmployee(int employeeId) {
		EmployeeEntity employee=jdbcTemplate.queryForObject("select * from employee where employeeId=?",new Object[] {employeeId},new BeanPropertyRowMapper<>(EmployeeEntity.class));
		return employee;
	}

	//update record (tier-2)
	@Override
	public String updateEmployee(EmployeeEntity employeeEntity) {
		Object[] data=new Object[] {employeeEntity.getEmployeeName(),employeeEntity.getSalary(),employeeEntity.getEmailId(),employeeEntity.getPassword(),employeeEntity.getEmployeeId()};
		int rowUpdated=jdbcTemplate.update("update employee set employeeName=?,salry=?,emailId=?,password=? where employeeid=?",data);
			
		return rowUpdated>0?"Record Updated Successfully":"Record not updated";
	}			
}
