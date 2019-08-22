package com.employee.web;


import com.employee.persistence.model.Employee;
import com.employee.service.EmployeeDTO;
import com.employee.service.EmployeeResponse;
import com.employee.service.EmployeeService.EmployeeService;
import javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(path = "/api")
public class EmployeeController {


    private EmployeeService employeeService;

    private EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;

    }

    @PostMapping(path = "/add_employee")
    public @ResponseBody Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {

        return employeeService.createEmployee(firstName, lastName);
    }


    @GetMapping(path = "/list_employees")
    public @ResponseBody
    List<Employee> getAllEmployees(){

        return employeeService.retrieveEmployees();
    }

    @PutMapping(path = "/update")
    public @ResponseBody EmployeeResponse updateEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int id) {
        EmployeeDTO employeeDTO = EmployeeDTO.builder().firstName(firstName).lastName(lastName).id(id).build();
        EmployeeResponse response = null;
        try {
            response = employeeService.updateEmployeeInfo(employeeDTO);
        } catch (NotFoundException e) {
            e.getMessage();
        }

        return response;
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteEmployee(@RequestParam int id) {

        employeeService.removeEmployee(id);

        return "deleted";
    }


}
