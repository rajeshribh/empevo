package com.evo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.evo.entities.Employee;
import com.evo.repositories.EmpRepository;


@Service
public class EmpService {
	
	@Autowired
	private EmpRepository erepo;
	

	public ResponseEntity<Employee> AddEmp(Employee e) {
		// TODO Auto-generated method stub
		Employee em=erepo.save(e);
		try {
			return new ResponseEntity<>(em,HttpStatus.CREATED);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}


	public ResponseEntity<Employee> getByid(int id) {
		// TODO Auto-generated method stub
		Optional<Employee>e=erepo.findById(id);
		if(e.isPresent())
		{
			return new ResponseEntity<>(e.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


	public ResponseEntity<List<Employee>> getAll() {
		// TODO Auto-generated method stub
		List<Employee> elist=erepo.findAll();
		
		if(elist.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Employee>>(elist,HttpStatus.OK);	
	}


	public ResponseEntity<String> deletebyid(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> e=erepo.findById(id);
		if(e.isPresent())
		{ 
			erepo.deleteById(id);
			return new ResponseEntity<>("Employee Deleted Successfully",HttpStatus.OK);
		}
		return new ResponseEntity<>("Employee Not found",HttpStatus.NOT_FOUND);
	}
	
	
	

}
