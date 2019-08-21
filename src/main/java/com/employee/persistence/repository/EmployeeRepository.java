package com.employee.persistence.repository;

import com.employee.persistence.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findFirstName(String firstname);

    List<Employee> findFirstById(Integer id);

    void deleteByFirstName(String firstname);

    void deleteById(Integer id);
}
