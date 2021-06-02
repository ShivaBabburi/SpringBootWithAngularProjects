package com.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.exception.ResourceNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/emp/")
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepo;
	
	//get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return empRepo.findAll();
	}
	
	//create Employee rest api
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee emp) {
		return empRepo.save(emp);
	}
	
	//get employee by id rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity< Employee> getEmployeeById(@PathVariable Long id) {
		Employee emp=empRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not existed with id :: "+id));
		return ResponseEntity.ok(emp);
	}
	
	// update employee rest api
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmp(@PathVariable long id, @RequestBody Employee emp){
		Employee emp1=empRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not existed with id :: "+id));
		emp1.setFirstName(emp.getFirstName());
		emp1.setLastName(emp.getLastName());
		emp1.setEmail(emp.getEmail());
		
		Employee updatedEmp=empRepo.save(emp1);
		
		return ResponseEntity.ok(updatedEmp);
	}
	
	//delete employee rest api
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Employee emp1=empRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not existed with id :: "+id));
		empRepo.delete(emp1);
		Map<String,Boolean> response=new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
