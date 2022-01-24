package com.godel.main_app.dao.mapper;

import com.godel.main_app.dto.Employee;
import com.godel.main_app.dto.Gender;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {

    private final static EmployeeMapper em = new EmployeeMapper();

    private EmployeeMapper() {
    }

    public static EmployeeMapper getInstance() {
        return em;
    }

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

        Employee emp = new Employee();

        emp.setId(rs.getInt("employee_id"));
        emp.setFirstName(rs.getString("first_name"));
        emp.setLastName(rs.getString("last_name"));
        emp.setDepartmentId(rs.getInt("department_id"));
        emp.setJobTitle(rs.getString("job_title"));
        emp.setGender(Gender.valueOf(rs.getString("gender")));
        emp.setDate_of_birth(rs.getDate("date_of_birth"));

        return emp;
    }
}
