package com.evo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evo.entities.Department;
import com.evo.entities.Employee;
import com.evo.services.DeptService;
import com.evo.services.EmpService;

@RestController
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	private DeptService dservice;
	
	@PostMapping("/add")
	public ResponseEntity<Department> addDept(@RequestBody Department e)
	{
		return dservice.AddDept(e);
	}

	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Department> GetbyId(@PathVariable ("id") int id)
	{
		return dservice.getByid(id);
	}
	
	@GetMapping("/getAll")
	public  ResponseEntity<List<Department>> GetAll()
	{
		return dservice.getAll();	
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<String> deletebyId(@PathVariable ("id") int id)
	{
		return dservice.deletebyid(id);
	}
}



