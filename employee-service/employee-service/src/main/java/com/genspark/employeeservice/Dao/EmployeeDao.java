package com.genspark.employeeservice.Dao;

import com.genspark.employeeservice.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long>
{

}
