package com.mongo.MongoDemo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.MongoDemo.model.Employee;
import com.mongo.MongoDemo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/")
	public Employee save(@RequestBody Employee emp) {
		return employeeService.save(emp);
	}
	
	@GetMapping("/")
	public List<Employee> getALL() {
		return employeeService.getAll();
	}
	
	@PutMapping("/")
	public Employee update(@RequestBody Employee emp) {
		return employeeService.update(emp);
	}
	
	@DeleteMapping("/")
	public long delete(@RequestBody Employee emp) {
		return employeeService.delete(emp);
	}
	
	@GetMapping("/salary/")
	public List<Employee> getBySalary(@PathParam("salary") int salary) {
		return employeeService.getBySalary(salary);
	}
	
	@GetMapping("/firstname/")
	public List<Employee> getByfirstName(@PathParam("firstName") String firstName) {
		return employeeService.getByfirstName(firstName);
	}

}
