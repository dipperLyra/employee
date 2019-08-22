package com.employee.service.EmployeeService.impl;

import com.employee.persistence.model.Employee;
import com.employee.persistence.repository.EmployeeRepository;
import com.employee.service.EmployeeDTO;
import com.employee.service.EmployeeResponse;
import com.employee.service.EmployeeService.EmployeeService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(String firstName, String lastName) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> retrieveEmployees() {
        List<Employee> employees = new ArrayList<>();

        employeeRepository.findAll().forEach(employee -> employees.add(employee));

        return employees;
    }


    @Override
    public EmployeeResponse updateEmployeeInfo(EmployeeDTO employeeDTO) throws NotFoundException {

        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeDTO.getId());

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setFirstName(employeeDTO.getFirstName());
            employee.setLastName(employeeDTO.getLastName());

            employeeRepository.save(employee);

            EmployeeResponse employeeResponse = EmployeeResponse.builder()
                    .firstName(employee.getFirstName())
                    .lastName(employee.getLastName())
                    .id(employee.getId())
                    .build();

            return employeeResponse;
        }

        throw new NotFoundException("Employee not found");
    }


    public void removeEmployee(int id) {
        employeeRepository.deleteById(id);
    }

}
