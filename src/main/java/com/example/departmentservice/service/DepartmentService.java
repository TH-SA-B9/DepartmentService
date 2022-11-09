package com.example.departmentservice.service;

import com.example.departmentservice.entity.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.departmentservice.repo.DepartmentRepository;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public void save (Department department) {
		log.info("Inside Service");
		departmentRepository.save(department);
	}
	
	public Optional<Department> findDepartmentById (Long id) {
		return departmentRepository.findById(id);
	}
}
