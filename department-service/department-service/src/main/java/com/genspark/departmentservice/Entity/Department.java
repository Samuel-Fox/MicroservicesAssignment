package com.genspark.departmentservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_emp")
public class Department
{
	@Id
	@Column(name="dept_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	private int employeeCount;

	public Department() {}

	public Department(long id, String name, int employeeCount)
	{
		this.id = id;
		this.name = name;
		this.employeeCount = employeeCount;
	}


	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getEmployeeCount()
	{
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount)
	{
		this.employeeCount = employeeCount;
	}
}
