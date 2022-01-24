package com.godel.main_app.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Employee implements Serializable {
    private static final long serialVersionUID = -936404450378313427L;
    private int id;
    private String firstName;
    private String lastName;
    private int departmentId;
    private String jobTitle;
    private Gender gender;
    private Date date_of_birth;

    public Map<String, Object> toMap() {
        Map<String, Object> values = new HashMap<>();
        values.put("first_name", firstName);
        values.put("last_name", lastName);
        values.put("department_id", departmentId);
        values.put("job_title", jobTitle);
        values.put("gender", gender.toString());
        values.put("date_of_birth", date_of_birth);
        return values;
    }

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, int departmentId, String jobTitle, Gender gender, Date date_of_birth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.jobTitle = jobTitle;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && departmentId == employee.departmentId && firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && jobTitle.equals(employee.jobTitle) && gender == employee.gender && date_of_birth.equals(employee.date_of_birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, departmentId, jobTitle, gender, date_of_birth);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentId=" + departmentId +
                ", jobTitle='" + jobTitle + '\'' +
                ", gender=" + gender +
                ", date_of_birth=" + date_of_birth +
                '}';
    }
}
