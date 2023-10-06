package com.genspark.employeeservice.Service;

import com.genspark.employeeservice.Dao.EmployeeDao;
import com.genspark.employeeservice.Entity.Employee;
import java.util.List;

public interface EmployeeService
{
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee addEmployee(Employee employee);
	Employee updateEmployee(Long id, Employee employee);
	void deleteEmployee(long id);

	List<Employee> findEmployeesByDeptId(long deptId);
}
