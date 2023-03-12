package com.mongo.MongoDemo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.MongoDemo.model.Employee;
import com.mongo.MongoDemo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public Employee save(Employee emp) {
		emp.setJoiningDate(new Date());
		return employeeRepository.save(emp);
	}

	public List<Employee> getAll() {
		return employeeRepository.find();
	}

	public Employee update(Employee emp) {
		emp.setJoiningDate(new Date());
		return employeeRepository.save(emp);
	}

	public long delete(Employee emp) {
		return employeeRepository.delete(emp);
	}

	public List<Employee> getBySalary(int salary) {
		return employeeRepository.findBySalary(salary);
	}

	public List<Employee> getByfirstName(String firstName) {
		return employeeRepository.findByfirstName(firstName);
	}

}
