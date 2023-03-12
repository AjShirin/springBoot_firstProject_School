package com.codeline.API.APIProjectFirst_Shirin.Repositories;

import com.codeline.API.APIProjectFirst_Shirin.Models.Course;
import com.codeline.API.APIProjectFirst_Shirin.Models.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    @Query("SELECT c from Course c where c.name= :courseName")
    Course getCourseByName(@Param("courseName") String course_name); // mapping the query and returning the Course

    @Query(value = "SELECT c from Course c where c.isActive = true")
    List<Course> getAllActiveCourse();

    @Query(value = "SELECT c from Course c where c.isActive = false")
    List<Course> getAllUnActiveCourse();

    @Query(value = "SELECT c from Course c where c.id = (SELECT Max(c.id) FROM Course c)")
    List<Course> getCourseLatestRow();

    @Query(value = "SELECT c from Course c where c.UpdatedDate = (SELECT MAX(c.UpdatedDate) FROM Course c)")
    List<Course> getCourseLatestUpdated();

    @Query("SELECT c from Course c where c.createdDate >= :createdDate")
    List<Course> getSchoolCreatedAfterDate(Date createdDate);

    @Query("SELECT c from Course c where c.name= :courseName")
        // the verifiable should
    Course getByCourseName(@Param("courseName") String course_name); // mapping the query and returning the school


//    @Query("SELECT c from Course c where c.student.id= :studentId")
//        // :id is coming from the user
//        // using parameter for user input which is "SchoolID"
//    Course getStudentByCourseId(@Param("studentId") Integer id);    // whoever called the function and write the ID, it will be mapped with the ID of the school
//    // calling the function from the service


}
