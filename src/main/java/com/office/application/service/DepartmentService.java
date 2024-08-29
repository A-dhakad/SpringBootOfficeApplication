package com.office.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.application.Repository.DepartmentRepo;
import com.office.application.entities.Departments;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepo objDepartmentRepo;
	
//	createDepartment
	public Departments createDepartment(Departments newDepartment) {
		return objDepartmentRepo.save(newDepartment);
	}
	
//	getAllDepartment
	public List<Departments> getAllDepartments() {
		return objDepartmentRepo.findAll();
	}
	
//	getDepartmentByID
	public Optional<Departments> getDepartmentById(long id) {
		return objDepartmentRepo.findById(id);
	}

	public Departments updateDepartment(Long departmentId, Departments updatedDepartment) {
	        Departments existingDepartment = objDepartmentRepo.findById(departmentId)
	                .orElseThrow(() -> new RuntimeException("Department not found with id " + departmentId));


	        existingDepartment.setName(updatedDepartment.getName());
	        existingDepartment.setDescription(updatedDepartment.getDescription());
	        existingDepartment.setDepartmentType(updatedDepartment.getDepartmentType());
//	        existingDepartment.setEmployees(updatedDepartment.getEmployees());

	        return objDepartmentRepo.save(existingDepartment);
	}

	public void deleteDepartment(Long depId) {
		if(objDepartmentRepo.existsById(depId)) {
			objDepartmentRepo.deleteById(depId);
		}
		else {
			throw new RuntimeException("Department not found with Id :" + depId);
		}
		
	}



}
