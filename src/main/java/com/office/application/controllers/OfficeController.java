package com.office.application.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.office.application.entities.Departments;
import com.office.application.entities.Employees;
import com.office.application.service.DepartmentService;
import com.office.application.service.EmployeeService;

@RestController
@RequestMapping("/office")
public class OfficeController {
	@Autowired
	public EmployeeService objEmployeeService;
	
	@Autowired
	public DepartmentService objDepartmentService;
	
//	postmapping for departments
	@PostMapping("/departments")
	public Departments createDepartment(@RequestBody Departments newDepartment) {
		return objDepartmentService.createDepartment(newDepartment);
	}
	
	@PostMapping("/employees")
	public Employees createEmployee(@RequestBody Employees newEmployee) {
		return objEmployeeService.createEmployee(newEmployee);
	}
	
//	getmapping
	 @GetMapping("/departments")
	 public List<Departments> getAllDepartments() {
		 return objDepartmentService.getAllDepartments();
	 }

	 @GetMapping("/employees")
	 public List<Employees> getAllEmployees() {
	     return objEmployeeService.getAllEmployees();
	 }
	 
//	    @GetMapping("/departments/{departmentId}/employees")
//	    public List<Employees> getEmployeesByDepartment(@PathVariable("departmentId") Long departmentId) {
//	        Optional<Departments> department = objDepartmentService.getDepartmentById(departmentId);
//	        return department.getEmployees().stream().toList();
//	    }

//	 Put mapping 
	 @PutMapping("/departments/{id}")
	 public Departments updateDepartment(@PathVariable("id") Long id, @RequestBody Departments department) {
		 return objDepartmentService.updateDepartment(id, department);
	 }
	 
//	 @PutMapping("/employees")
//	 public Employees updateEmployee( @RequestBody Employees updated_Employee) {
//		 return objEmployeeService.updateEmployee(updated_Employee);
//	 }
	 
	 @PutMapping("/employees/{id}")
	 public ResponseEntity<Employees> updateEmployee(@PathVariable("id") Long id, @RequestBody Employees updatedEmployee) {
		 Employees updated = objEmployeeService.updateEmployee(id, updatedEmployee);
		 return ResponseEntity.ok(updated);
	 }
	 
//	 delete the employee By Id
	 @DeleteMapping("/employees/{empId}")
	 public ResponseEntity<Object> deleteEmployee(@PathVariable("empId") Long empId){
		 try {
			 objEmployeeService.deleteEmployee(empId);
			 return ResponseEntity.noContent().build();
		 }
		 catch(Exception e) {
			 return ResponseEntity.notFound().build();
		 }
	 }
	 
//	 delete the department By Id
	 @DeleteMapping("/departments/{depId}")
	 public ResponseEntity<Object> deleteDepartment(@PathVariable("depId") Long depId){
		 try {
			 objDepartmentService.deleteDepartment(depId);
			 return ResponseEntity.noContent().build();
		 }	
		 catch(Exception e) {
			 return ResponseEntity.notFound().build();
		 }
	 }
	 
}
