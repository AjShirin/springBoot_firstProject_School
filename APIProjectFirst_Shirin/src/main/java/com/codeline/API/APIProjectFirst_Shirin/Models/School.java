package com.codeline.API.APIProjectFirst_Shirin.Models;

import javax.persistence.*;
import java.util.Date;

// to create tables and bring data from table into objects of models
@Entity
public class School extends BaseEntity{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "school_name")
    String name;

//   @OneToMany // Doing the relation
//   @JoinColumn(referencedColumnName = "id")// defining the foreign key which is ID
    //List<Student> students; //comment out because it will create a cyclic mapping

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



//    public void setName(String name) {
//        this.name = name;
//    }


//    public List<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }
}
