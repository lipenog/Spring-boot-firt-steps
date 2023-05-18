package com.example.simplecrud.service;

import com.example.simplecrud.entity.Employee;
import com.example.simplecrud.entity.Product;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int id);
    public Employee save(Employee employee);
    public void deleteEmployeeById(int id);
}
