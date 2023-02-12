package com.codeline.API.APIProjectFirst_Shirin.Repositories;

import com.codeline.API.APIProjectFirst_Shirin.Models.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Collection of code that is going to be used for the Objects
// The class is dealing with student and the primary key in Integer
// using inheritance
// to speak to database and give data to service
public interface SchoolRepository extends CrudRepository<School, Integer> {
    @Query("SELECT s from School s")
// Write SQL query,  "s" can be any alphabet which is like static
    List<School> getAllSchools();

    // Write SQL query,  "s" can be any alphabet which is like static
    // s is like alias
    @Query("SELECT s from School s where s.id= :schoolId")
    // :id is coming from the user
    // using parameter for user input which is "SchoolID"
    School getSchoolById(@Param("schoolId") Integer id); // mapping the query and returning the school
    // whoever called the function and write the ID, it will be mapped with the ID of the school
    // calling the function from the service
}
