package com.example.demo.rest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("list/{id}")
	public Optional<Employee> getEmployee(@PathVariable Integer id){
		return employeedao.findById(id);
	}
	
	@PostMapping("/save")
	public Boolean save (@RequestBody Employee employee) {
		try {
			return employeedao.save(employee)!=null?true:false;	
		}catch(Exception ex) {
			return false;
		}
		
	}
	
	
}
