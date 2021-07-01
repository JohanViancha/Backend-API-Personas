package com.example.demo.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeRest {

	@Autowired
	private EmployeeDAO employeedao;
	
	@GetMapping("/list")
	public List<Employee>list(){
		return employeedao.findAll();
	}
	
	@GetMapping("/list/{id}")
	public Employee getEmployee(Integer id){
		return employeedao.getById(id);
	}
	
	@PostMapping("/save")
	public void save (@RequestBody Employee employee) {
		employeedao.save(employee);
	}
	
	
}
