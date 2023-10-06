package com.genspark.departmentservice.Dao;

import com.genspark.departmentservice.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Long>
{
}
