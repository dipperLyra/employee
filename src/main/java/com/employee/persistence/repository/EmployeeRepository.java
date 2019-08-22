package com.employee.persistence.repository;

import com.employee.persistence.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Optional<Employee> findEmployeeByFirstName(String firstName);

    List<Employee> getAllByFirstName(String firstName);

    void deleteByFirstName(String firstName);

    void deleteById(Integer id);
}
