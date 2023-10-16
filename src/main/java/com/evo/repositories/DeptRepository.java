package com.evo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evo.entities.Department;

@Repository
public interface DeptRepository extends JpaRepository<Department, Integer>{

}
