package com.genspark.employeeservice.Controller;

import com.genspark.employeeservice.Entity.Employee;
import com.genspark.employeeservice.Service.EmployeeService;
import jakarta.ws.rs.Path;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController
{
	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<Employee> getEmployees()
	{
		return this.employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable String id)
	{
		return this.employeeService.getEmployeeById(Long.parseLong(id));
	}

	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return this.employeeService.addEmployee(employee);
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee)
	{
		return this.employeeService.updateEmployee(id, employee);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable String id)
	{
		this.employeeService.deleteEmployee(Long.parseLong(id));
	}

	@GetMapping("/dept")
	public List<Employee> getEmployeesByDeptId(@RequestParam("deptId") long deptId)
	{
		return this.employeeService.findEmployeesByDeptId(deptId);
	}


}
