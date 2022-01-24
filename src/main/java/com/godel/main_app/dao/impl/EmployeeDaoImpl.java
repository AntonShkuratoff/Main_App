package com.godel.main_app.dao.impl;

import com.godel.main_app.dao.EmployeeDao;
import com.godel.main_app.dao.mapper.EmployeeMapper;
import com.godel.main_app.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SQL_SELECT_ALL = "SELECT * FROM employee";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM employee WHERE employee_id = ?";
    private static final String SQL_UPDATE = "UPDATE employee SET first_name = ?, last_name = ?, " +
            "department_id = ?, job_title = ?, gender = ?, date_of_birth = ?  WHERE employee_id = ?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM employee WHERE employee_id = ?";

    @Override
    public List<Employee> getList() {
        return jdbcTemplate.query(SQL_SELECT_ALL, EmployeeMapper.getInstance());
        }

    @Override
    public Employee get(int id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, EmployeeMapper.getInstance(), id);
    }

    @Override
    public void add(Employee employee) {
        new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("employee")
                .usingGeneratedKeyColumns("employee_id")
                .executeAndReturnKey(employee.toMap()).intValue();
    }

    @Override
    public void update(Employee emp) {
        jdbcTemplate.update(SQL_UPDATE, emp.getFirstName(), emp.getLastName(), emp.getDepartmentId(), emp.getJobTitle(),
                emp.getGender().toString(), emp.getDate_of_birth(), emp.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(SQL_DELETE_BY_ID, id);
    }
}
