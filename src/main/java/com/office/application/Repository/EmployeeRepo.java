package com.office.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.office.application.entities.Employees;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees, Long> {

}
