package com.example.simplecrud.repository;

import com.example.simplecrud.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
@Repository
//@RepositoryRestResource(path = "myDepartments") // change the path at the endpoint to the path variable
                                                // localhost:8080/api/myDepartments instead of .../api/departments
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
