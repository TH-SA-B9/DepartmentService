package com.example.departmentservice.controller;

import com.example.departmentservice.entity.Department;
import com.example.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/save")
	public ResponseEntity<Department> saveDepartment (@RequestBody Department department) {
		departmentService.save(department);
		return ResponseEntity.ok().body(department);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Department> getDepartmentById (@PathVariable Long id) {
		Optional<Department> department = departmentService.findDepartmentById(id);
		if(department.isPresent()){
			return ResponseEntity.ok().body(department.get());
		}else{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/hello")
	public String hello () {
		return "Hello";
	}
}
