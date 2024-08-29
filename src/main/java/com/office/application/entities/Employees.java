package com.office.application.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employees {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private Double salary;
	private Boolean isActive;
	private String role;
	
	@ManyToOne
    @JoinColumn(name = "department_id")
    private Departments department;

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employees(long id, String name, Double salary, Boolean isActive, String role, Departments department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.isActive = isActive;
		this.role = role;
		this.department = department;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Departments getDepartment() {
		return department;
	}

	public void setDepartment(Departments department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", salary=" + salary + ", isActive=" + isActive + ", role="
				+ role + ", department=" + department + "]";
	}
	
}
