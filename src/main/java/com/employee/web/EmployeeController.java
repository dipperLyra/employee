package com.employee.web;


import com.employee.persistence.model.Employee;
import com.employee.persistence.repository.EmployeeRepository;
import com.employee.service.EmployeeDTO;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping(path = "/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    private EmployeeService service;

    @PostMapping(path = "/add_employee")
    public @ResponseBody String addEmployee(@RequestParam String firstName, @RequestParam String lastName) {

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);

        employeeRepository.save(employee);
        return "saved";
    }

    @GetMapping(path = "/list_employee")
    public @ResponseBody Iterable<Employee> getAllEmployees(){

        return employeeRepository.findAll();
    }

    @GetMapping(path = "/update")
    public @ResponseBody String updateEmployee() {
        service.retrieveEmployees();

        return "record retrieved";
    }

    @GetMapping(path = "/delete")
    public @ResponseBody String deleteEmployee(@RequestParam int id) {

        employeeRepository.deleteById(id);

        return "deleted";
    }


}
