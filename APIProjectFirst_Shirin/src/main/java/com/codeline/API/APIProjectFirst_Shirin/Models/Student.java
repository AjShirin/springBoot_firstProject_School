package com.codeline.API.APIProjectFirst_Shirin.Models;

import javax.persistence.*;
import java.util.List;

@Entity // This annotation "entity" tells spring boot that this class is going to be a table in sql
//@Table(name = "dbo.Student")
public class Student {


    @Id // Defining the Primary key
    // To make the primary key … just like "Identity/Auto Increment"
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    // gives the column name/ if you want to make it different you can do it
    // by default everything is true
    @Column(name = "student_name")
    String name;
    String rollNumber;
    @OneToMany
    @JoinColumn(referencedColumnName = "id")// defining the foreign key which is ID
    List<Course> courses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;


    }
}
