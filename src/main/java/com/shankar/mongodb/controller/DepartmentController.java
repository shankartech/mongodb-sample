package com.shankar.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shankar.mongodb.bean.Department;
import com.shankar.mongodb.repository.DeptRepository;

@RestController
public class DepartmentController {
	
	@Autowired
	DeptRepository departmentRepository;
	
	@PostMapping("/dept/create")
	public Department createDept(@RequestBody Department department) {
		departmentRepository.save(department);
		return department;
	}
	
	@GetMapping
	public List listDepts(){
	    return departmentRepository.findAll();
	 }
	
	@PutMapping("/{deptId}")
    public Department updateDept(@RequestBody Department department, @PathVariable String deptId) {
        department.setId(deptId);
        departmentRepository.save(department);
        return department;
    }
	
	@DeleteMapping("/{deptId}")
    public String deleteDept(@PathVariable String deptId) {
        departmentRepository.deleteById(deptId);
        return deptId;
    }
	
	@GetMapping("/{deptName}")
    public List findDeptByName(@PathVariable String deptName) {
        return departmentRepository.findDepartmentByName(deptName);
    }
	
//	@GetMapping("{name}/emp")
//    public Department listDept(@PathVariable String name){
//        return departmentRepository.findDepartmentByEmployeeName(name);
//    }

}
