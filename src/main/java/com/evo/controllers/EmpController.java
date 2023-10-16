package com.evo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evo.entities.Employee;
import com.evo.services.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private EmpService eservice;
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmp(@RequestBody Employee e)
	{
		return eservice.AddEmp(e);
	}

	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Employee> GetbyId(@PathVariable ("id") int id)
	{
		return eservice.getByid(id);
	}
	
	@GetMapping("/getAll")
	public  ResponseEntity<List<Employee>> GetAll()
	{
		return eservice.getAll();	
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<String> deletebyId(@PathVariable ("id") int id)
	{
		return eservice.deletebyid(id);
	}
}
