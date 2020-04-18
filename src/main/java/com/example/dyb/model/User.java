package com.example.dyb.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(description="All details about the user")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User
{
    //making Id as primary key
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=5, message="Name should have atleast 5 characters")
    @ApiModelProperty(notes="name should have atleast 5 characters")
    private String name;

    @Past
    @ApiModelProperty(notes="Birth date should be in the past")
    private Date dob;

    public User(String name, Date dob) {
        this.name =name;
        this.dob=dob;
    }

    @Override
    public String toString()
    {
      return String.format("User [id=%s, name=%s, dob=%s]", id, name, dob);
    }
}