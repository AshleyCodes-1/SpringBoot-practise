package com.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.EmployeeDTO;
import com.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping({"/login","/"})
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping("loginValidate")
	public String authenticateEmployee(@RequestParam String emailId, @RequestParam String password, Model model) {
		EmployeeDTO employeeDTO = employeeService.authenticate(emailId, password);

		if (employeeDTO != null) {
			model.addAttribute("employeeDTO", employeeDTO);
			return "showEmployee";
		} else {
			model.addAttribute("msg", "Wrong credential! Re-try--");
			return "login";
		}
	}
	
	//fetch all the records from employee table
	@GetMapping("/showEmployee")
	public String getAllEmployee(Model model) {
		List<EmployeeDTO> employeeDTO=employeeService.getAllEmployee();
			
		System.out.println("List of Employees:   ="+employeeDTO.size());  
		model.addAttribute("employeeDTO", employeeDTO);
			
		return "showAll";    
	}
		
	//code for getting registration page
	@GetMapping("/registration")
	public String empRegistration() {
			
		return "employeeRegistration";
	}

	//code for registering new candidate      
	@PostMapping("/employeeRegistration")
	public String employeeRegistration(@ModelAttribute EmployeeDTO employeeDTO, Model model) {
		String message=employeeService.saveEmployee(employeeDTO);
		model.addAttribute("message",message);
			
		return "employeeRegistration";
	}

	//delete operation
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam String employeeId, Model model) {
		employeeService.deleteEmployee(employeeId);
		model.addAttribute("message","record deleted successfully");
				
		return "redirect:/showEmployee";  //after deleting a record, rest of the records will appear over there on same page ie - showEmployee
	}
		
	//update operation (step-1)
	@GetMapping("/updateEmployee")
	public String updateEmployee(@RequestParam int employeeId, Model model) {
		EmployeeDTO employee=employeeService.getEmployee(employeeId);
			
		model.addAttribute("employee", employee);
		return "updateEmployee";    //updateEmployee.jsp
	}
		
	//update operation (tier-2)
	@PostMapping("/updateEmployee")
	public String updateEmployee(@ModelAttribute EmployeeDTO employeeDTO, Model model) {
		String message=employeeService.updateEmployee(employeeDTO);
		model.addAttribute("message", message);
		return "updateEmployee";
	}
}