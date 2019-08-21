package com.employee.service;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class EmployeeDTO {

    private String firstName;
    private String lastName;
    private Integer id;
}
