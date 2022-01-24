package com.godel.main_app.service.impl;

import com.godel.main_app.dao.EmployeeDao;
import com.godel.main_app.dto.Employee;
import com.godel.main_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<Employee> getList() {
        return employeeDao.getList();
    }

    @Override
    public Employee get(int id) {
        return employeeDao.get(id);
    }

    @Override
    public void add(Employee employee) {
        employeeDao.add(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void delete(int id) {
        employeeDao.delete(id);
    }
}
