package com.evo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.evo.entities.Department;
import com.evo.entities.Employee;
import com.evo.repositories.DeptRepository;
import com.evo.repositories.EmpRepository;

@Service
public class DeptService {
	
	@Autowired
	private DeptRepository drepo;
	

	

	public ResponseEntity<Department> AddDept(Department e) {
		// TODO Auto-generated method stub
		Department em=drepo.save(e);
		try {
			return new ResponseEntity<>(em,HttpStatus.CREATED);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}


	public ResponseEntity<Department> getByid(int id) {
		// TODO Auto-generated method stub
		Optional<Department>e=drepo.findById(id);
		if(e.isPresent())
		{
			return new ResponseEntity<>(e.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


	public ResponseEntity<List<Department>> getAll() {
		// TODO Auto-generated method stub
		List<Department> elist=drepo.findAll();
		
		if(elist.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Department>>(elist,HttpStatus.OK);	
	}


	public ResponseEntity<String> deletebyid(int id) {
		// TODO Auto-generated method stub
		Optional<Department> e=drepo.findById(id);
		if(e.isPresent())
		{ 
			drepo.deleteById(id);
			return new ResponseEntity<>("Employee Deleted Successfully",HttpStatus.OK);
		}
		return new ResponseEntity<>("Employee Not found",HttpStatus.NOT_FOUND);
	}
	
	
	

}
