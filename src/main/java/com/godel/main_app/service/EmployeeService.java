package com.godel.main_app.service;

import com.godel.main_app.dto.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getList();

    Employee get(int id);

    void add(Employee employee);

    void update(Employee employee);

    void delete(int id);
}
