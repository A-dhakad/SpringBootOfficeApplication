package com.office.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.application.Repository.EmployeeRepo;
import com.office.application.entities.Employees;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo objEmployeeRepo;
	
//	create employees
	public Employees createEmployee(Employees newEmployee) {
		return objEmployeeRepo.save(newEmployee);
	}
	
//	getAllEmployees
	public List<Employees> getAllEmployees() {
		return objEmployeeRepo.findAll();
	}
	
//	getEmployeeByID
	public Optional<Employees> getEmployeeById(long id) {
		return objEmployeeRepo.findById(id);
	}

    public Employees updateEmployee(Long id, Employees updatedEmployee) {
        Employees existingEmployee = objEmployeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));

        // Update the fields of the existing employee
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        existingEmployee.setRole(updatedEmployee.getRole());
        existingEmployee.setIsActive(updatedEmployee.getIsActive());

        // Save the updated employee to the database
        return objEmployeeRepo.save(existingEmployee);
    }
    
//    delete the employees
    public void deleteEmployee(Long empId) {
    	if(objEmployeeRepo.existsById(empId)) {
    		objEmployeeRepo.deleteById(empId);
    	}
    	else {
    		throw new RuntimeException("employee not found with Id :" + empId);
    	}
    }
	
}
