package com.godel.main_app.rest;

import com.godel.main_app.dto.Employee;
import com.godel.main_app.service.EmployeeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "Get a list of all employees", notes = "Returns a list with all employees from the DB")
    @GetMapping("/employees")
    public List<Employee> getList() {
        return employeeService.getList();
    }

    @ApiOperation(value = "Get an employee", notes = "Returns an employee from the DB by ID")
    @ApiImplicitParam(name = "id", value ="User ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/employees/{id}")
    public Employee get(@PathVariable int id) {
        return employeeService.get(id);
    }

    @ApiOperation(value = "Create an employee", notes = "Adds a new employee to the DB based on given Employee object.")
    @ApiImplicitParam(name = "employee", value ="Employee data", required = true, dataType = "Employee")
    @PostMapping("/employees")
    public void add(@RequestBody Employee emp) {
        employeeService.add(emp);
    }

    @ApiOperation(value = "Update an employee", notes = "Updates an employee in the DB based on given Employee object.")
    @ApiImplicitParam(name = "employee", value ="Employee data", required = true, dataType = "Employee")
    @PutMapping("/employees")
    public void update(@RequestBody Employee emp) {
        employeeService.update(emp);
    }

    @ApiOperation(value = "Delete an employee", notes = "Deletes an employee from the DB by ID")
    @ApiImplicitParam(name = "id", value ="User ID", required = true, dataType = "Integer", paramType = "path")
    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable int id) {
        employeeService.delete(id);
    }
}
