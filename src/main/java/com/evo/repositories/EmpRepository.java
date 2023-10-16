package com.evo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evo.entities.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
