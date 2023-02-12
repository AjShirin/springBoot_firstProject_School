package com.codeline.API.APIProjectFirst_Shirin.Repositories;

import com.codeline.API.APIProjectFirst_Shirin.Models.Mark;
import com.codeline.API.APIProjectFirst_Shirin.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Collection of code that is going to be used for the Objects
// to speak to database and give data to service
// The class is dealing with student and the primary key in Integer
// using inheritance
public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Query("SELECT s from Student s")
// Write SQL query,  "s" can be any alphabet which is like static
    List<Student> getAllStudent();

    @Query("SELECT s from Student s where s.id= :studentId")
        // :id is coming from the user
        // using parameter for user input which is "studentId"
    Student getStudentById(@Param("studentId") Integer id);  // whoever called the function and write the ID, it will be mapped with the ID of the school
    // calling the function from the service

}
