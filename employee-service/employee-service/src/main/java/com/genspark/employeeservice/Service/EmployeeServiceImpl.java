package com.genspark.employeeservice.Service;

import com.genspark.employeeservice.Dao.EmployeeDao;
import com.genspark.employeeservice.Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployees()
	{
		return this.employeeDao.findAll();
	}

	@Override
	public Employee getEmployeeById(long id)
	{
		Optional <Employee> e = this.employeeDao.findById(id);
		Employee employee = null;
		if(e.isPresent()) {
			employee = e.get();
		} else {
			throw new RuntimeException("Employee not found with id : " + id);
		}
		return employee;
	}

	@Override
	public Employee addEmployee(Employee employee)
	{
		return this.employeeDao.save(employee);
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee)
	{
		Employee employeeToUpdate = employeeDao.findById(id).orElse(null);
		if (employeeToUpdate != null)
		{
			employeeToUpdate.setName(employee.getName());
			employeeToUpdate.setTitle(employee.getTitle());
			employeeToUpdate.setSalary(employee.getSalary());
			employeeToUpdate.setDeptId(employee.getDeptId());
			return employeeDao.save(employeeToUpdate);
		}
		return null;
	}

	@Override
	public void deleteEmployee(long id)
	{
		this.employeeDao.deleteById(id);
	}

	@Override
	public List<Employee> findEmployeesByDeptId(long deptId)
	{
		TypedQuery<Employee> query = entityManager.createQuery(
			"SELECT e FROM Employee e WHERE e.deptId = :deptId", Employee.class);
		query.setParameter("deptId", deptId);

		return query.getResultList();
	}

	@PersistenceContext
	private EntityManager entityManager;
}
