package com.office.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.office.application.entities.Departments;

@Repository
public interface DepartmentRepo extends JpaRepository<Departments, Long> {

}
