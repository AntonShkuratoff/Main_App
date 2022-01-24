package com.godel.main_app.service;

import com.godel.main_app.dao.EmployeeDao;
import com.godel.main_app.dto.Employee;
import com.godel.main_app.dto.Gender;
import com.godel.main_app.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

@SpringBootTest
public class EmployeeServiceImplTest {

    Employee empFirst = new Employee(1, "John", "Konstantin", 1, "EXORCIST", Gender.MALE, Date.valueOf("1953-05-10"));
    Employee empSecond = new Employee(2, "John", "Wick", 2, "PROBLEM SOLVER", Gender.MALE, Date.valueOf("1964-09-02"));
    Employee empThird = new Employee(3, "Thomas", "Anderson", 3, "HACKER", Gender.MALE, Date.valueOf("1962-03-11"));

    @Mock
    private EmployeeDao dao;

    @InjectMocks
    private EmployeeServiceImpl service = new EmployeeServiceImpl();

    @Test
    public void getListTest() {
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(empFirst, empSecond, empThird));
        Mockito.when(dao.getList()).thenReturn(employeeList);

        List<Employee> empList = service.getList();
        assertEquals(3, empList.size());
        Mockito.verify(dao, times(1)).getList();
    }

    @Test
    public void getTest() {
        Mockito.when(dao.get(1)).thenReturn(new Employee(1, "John", "Konstantin", 1, "EXORCIST", Gender.MALE, Date.valueOf("1953-05-10")));

        Employee emp = service.get(1);
        assertEquals(empFirst, emp);
        Mockito.verify(dao, times(1)).get(1);
    }

    @Test
    public void addTest() {
        service.add(empFirst);

        Mockito.verify(dao, times(1)).add(empFirst);
    }
}
