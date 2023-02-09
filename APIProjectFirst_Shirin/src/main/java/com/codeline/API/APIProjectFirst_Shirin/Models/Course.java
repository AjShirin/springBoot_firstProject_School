package com.codeline.API.APIProjectFirst_Shirin.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {

    @Id // Defining the Primary key
    // To make the primary key … just like "Identity/Auto Increment"
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    // gives the column name/ if you want to make it different you can do it
    // by default everything is true
    @Column(name = "course_name")
    String name;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")// defining the foreign key which is ID
    Student student;


//    @OneToMany
//    @JoinColumn(referencedColumnName = "id")// defining the foreign key which is ID
//    List<Mark> marks;

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

//    public List<Mark> getMarks() {
//        return marks;
//    }
//
//    public void setMarks(List<Mark> marks) {
//        this.marks = marks;
//    }

}
