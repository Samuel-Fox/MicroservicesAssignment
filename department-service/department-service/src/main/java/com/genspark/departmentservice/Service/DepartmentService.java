package com.genspark.departmentservice.Service;

import com.genspark.departmentservice.Entity.Department;
import java.util.List;

public interface DepartmentService
{
	List<Department> getAllDepartments();
	Department getDepartmentById(long id);
	Department addDepartment(Department department);
	Department updateDepartment(Long id, Department department);
	void deleteDepartment(long id);
}
