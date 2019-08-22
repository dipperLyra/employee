package com.employee.service.EmployeeService;

import com.employee.persistence.model.Employee;
import com.employee.service.EmployeeDTO;
import com.employee.service.EmployeeResponse;
import javassist.NotFoundException;

import java.util.List;

public interface EmployeeService {
    List<Employee> retrieveEmployees();

    EmployeeResponse updateEmployeeInfo(EmployeeDTO employeeDTO) throws NotFoundException;

    Employee createEmployee(String firstName, String lastName);

    public void removeEmployee(int id);
}
