package com.example.dyb.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//mark class as an Entity
@Entity
//defining class name as Table name
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description="All details about the user")
public class Books
{
    //Defining book id as primary key
    @Id
    @Column
    private int bookId;
    @Column
    @NotBlank(message = "Book Name required")
    private String bookName;
    @Column(updatable = false,unique = true)
    @ApiModelProperty(notes="Author name should have at least 5 characters")
    @Size(min=5,message="Author Name should have at least 5 characters")
    @NotBlank(message = "Author Name required")
    private String author;
    @Column
    @NotNull
    private int price;
 }