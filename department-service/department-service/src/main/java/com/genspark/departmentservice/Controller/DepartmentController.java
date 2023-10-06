package com.genspark.departmentservice.Controller;

import com.genspark.departmentservice.Entity.Department;
import com.genspark.departmentservice.Service.DepartmentService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController
{
	@Autowired
	private DepartmentService departmentService;

	@GetMapping
	public List<Department> getDepartments() {
		return this.departmentService.getAllDepartments();
	}

	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable Long id) {
		return this.departmentService.getDepartmentById(id);
	}

	@PostMapping
	public Department addDepartment(@RequestBody Department department) {
		return this.departmentService.addDepartment(department);
	}

	@PutMapping("/{id}")
	public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
		return this.departmentService.updateDepartment(id, department);
	}

	@DeleteMapping("/{id}")
	public void deleteDepartment(@PathVariable Long id) {
		this.departmentService.deleteDepartment(id);
	}
}
