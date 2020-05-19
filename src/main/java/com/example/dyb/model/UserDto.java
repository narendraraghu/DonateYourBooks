package com.example.dyb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int age;
    private long salary;
    private Date createdDate;
}
