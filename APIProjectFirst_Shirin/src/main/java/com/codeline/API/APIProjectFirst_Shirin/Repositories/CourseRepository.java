package com.codeline.API.APIProjectFirst_Shirin.Repositories;

import com.codeline.API.APIProjectFirst_Shirin.Models.Course;
import com.codeline.API.APIProjectFirst_Shirin.Models.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Collection of code that is going to be used for the Objects
// to speak to database and give data to service
// The class is dealing with student and the primary key in Integer
// using inheritance
public interface CourseRepository extends CrudRepository<Course, Integer> {
    @Query("SELECT c from Course c")
// Write SQL query,  "s" can be any alphabet which is like static
    List<Course> getAllCourse();

    // Write SQL query,  "s" can be any alphabet which is like static
    // s is like alias
    @Query("SELECT c from Course c where c.id= :courseId")
    // :id is coming from the user
    // using parameter for user input which is "SchoolID"
    Course getCourseById(@Param("courseId") Integer id);    // whoever called the function and write the ID, it will be mapped with the ID of the school
    // calling the function from the service
}
