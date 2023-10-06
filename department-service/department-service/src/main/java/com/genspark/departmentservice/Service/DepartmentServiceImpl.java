package com.genspark.departmentservice.Service;

import com.genspark.departmentservice.Dao.DepartmentDao;
import com.genspark.departmentservice.Entity.Department;
import com.netflix.discovery.converters.Auto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public List<Department> getAllDepartments()
	{
		return this.departmentDao.findAll();
	}

	@Override
	public Department getDepartmentById(long id)
	{
		Optional<Department> d = this.departmentDao.findById(id);
		Department department = null;
		if(d.isPresent()) {
			department = d.get();
		} else {
			throw new RuntimeException("Department not found with id : " + id);
		}
		return department;
	}

	@Override
	public Department addDepartment(Department department)
	{
		return this.departmentDao.save(department);
	}

	@Override
	public Department updateDepartment(Long id, Department department)
	{
		Department departmentToUpdate = departmentDao.findById(id).orElse(null);
		if(departmentToUpdate != null)
		{
			departmentToUpdate.setName(department.getName());
			departmentToUpdate.setEmployeeCount(department.getEmployeeCount());
			return departmentDao.save(departmentToUpdate);
		}
		return null;
	}

	@Override
	public void deleteDepartment(long id)
	{
		this.departmentDao.deleteById(id);
	}
}
