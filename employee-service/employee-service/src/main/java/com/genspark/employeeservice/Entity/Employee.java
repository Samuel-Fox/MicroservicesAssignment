package com.genspark.employeeservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_emp")
public class Employee
{
	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	private String title;

	private double salary;

	private long deptId;

	public Employee() {}

	public Employee(long id, String name, String title, double salary, long deptId)
	{
		this.id = id;
		this.name = name;
		this.title = title;
		this.salary = salary;
		this.deptId = deptId;
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

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}

	public long getDeptId()
	{
		return deptId;
	}

	public void setDeptId(long deptId)
	{
		this.deptId = deptId;
	}
}
