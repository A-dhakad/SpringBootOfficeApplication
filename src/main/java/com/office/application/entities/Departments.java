package com.office.application.entities;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Departments {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String name;
	
	@Column(length = 1000)
	private String description;
	
	@Enumerated(EnumType.STRING)
    private DepartmentType departmentType;
	
//	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Employees> employees;

	public Departments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Departments(Long id, String name, String description, DepartmentType departmentType) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.departmentType = departmentType;
//		this.employees = employees;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DepartmentType getDepartmentType() {
		return departmentType;
	}

	public void setDepartmentType(DepartmentType departmentType) {
		this.departmentType = departmentType;
	}

//	public Set<Employees> getEmployees() {
//		return employees;
//	}
//
//	public void setEmployees(Set<Employees> employees) {
//		this.employees = employees;
//	}

	@Override
	public String toString() {
		return "Departments [id=" + id + ", name=" + name + ", description=" + description + ", employees=" 
				+ "]";
	}
	
	enum DepartmentType{
		HR, IT, SALES, MARKETING, AI
	}
}
