package com.employee.service;

import com.employee.persistence.model.Employee;
import com.employee.persistence.repository.EmployeeRepository;
//import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;


    public Iterable retrieveEmployees() {

        return employeeRepository.findAll();
    }


    @Transactional
    public EmployeeResponse updateEmployeeInfo(EmployeeDTO employeeDTO) {

        Optional<Employee> opotionalEmployee = employeeRepository.findById(employeeDTO.getId());

        if (!opotionalEmployee.isPresent()) {
           // throw new NotFoundException("Employee not found");
        }

        Employee employee = opotionalEmployee.get();
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
}
