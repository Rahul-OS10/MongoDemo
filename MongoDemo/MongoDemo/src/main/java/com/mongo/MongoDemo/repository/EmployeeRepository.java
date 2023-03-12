package com.mongo.MongoDemo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongo.MongoDemo.model.Employee;

@Repository
public class EmployeeRepository {
	
	@Autowired
	MongoTemplate mongoTemplate;

	public Employee save(Employee emp) {
		
//		Everytime when need to retrieve or save obj , needs to use this for each field
//		BasicDBObject obj=new BasicDBObject();
//		obj.append("firstName", emp.getFirstName());
		
//		Here , mongoTemplate using domain object(emp) to perform above operation
		return mongoTemplate.save(emp);
	}

	public List<Employee> find() {
		return mongoTemplate.findAll(Employee.class);
	}

	public long delete(Employee emp) {
		return mongoTemplate.remove(emp).getDeletedCount();
	}

	public List<Employee> findBySalary(int salary) {
		Query query = new Query(Criteria.where("salary").gte(salary));
		return mongoTemplate.find(query, Employee.class);
	}
	
	public List<Employee> findByfirstName(String firstName) {
		Query query = new Query(Criteria.where("firstName").regex("^"+firstName));
		return mongoTemplate.find(query, Employee.class);
	}

}
