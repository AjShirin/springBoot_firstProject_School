package com.codeline.API.APIProjectFirst_Shirin.Repositories;

import com.codeline.API.APIProjectFirst_Shirin.Models.Course;
import com.codeline.API.APIProjectFirst_Shirin.Models.Mark;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Collection of code that is going to be used for the Objects
// to speak to database and give data to service
// The class is dealing with student and the primary key in Integer
// using inheritance
public interface MarkRepository extends CrudRepository<Mark, Integer> {

    @Query("SELECT m from Mark m")
// Write SQL query,  "m" can be any alphabet which is like static
    List<Mark> getAllMarks();

    // Write SQL query,  "m" can be any alphabet which is like static
    // s is like alias
    @Query("SELECT m from Mark m where m.id= :markId")
    // :id is coming from the user
    // using parameter for user input which is "SchoolID"
    Mark getMarkById(@Param("markId") Integer id);  // whoever called the function and write the ID, it will be mapped with the ID of the school
    // calling the function from the service
}
