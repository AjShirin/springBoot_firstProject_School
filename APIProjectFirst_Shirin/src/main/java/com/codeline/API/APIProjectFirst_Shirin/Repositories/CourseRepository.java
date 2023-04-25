package com.codeline.API.APIProjectFirst_Shirin.Repositories;

import com.codeline.API.APIProjectFirst_Shirin.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository // Collection of code that is going to be used for the Objects
// to speak to database and give data to service
// The class is dealing with student and the primary key in Integer
// using inheritance
public interface CourseRepository extends JpaRepository<Course, Integer> {
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

//    @Query("SELECT c from Course c where c.name= :courseName")
//    Course getCourseByName(@Param("courseName") String course_name); // mapping the query and returning the Course

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
    List<Course> getByCourseName(@Param("courseName") String courseName); // mapping the query and returning the course

    @Query(value = "Select * from Course where created_date like CONCAT (?1, '%') ", nativeQuery = true) // nativeQuery you can use the variables in the sql
        //The CONCAT(?1, '%')  is used to concatenate the value of the first parameter passed to the method
        // (which is the createdDate parameter) with the %  symbol.
        // This creates a pattern to match all values in the created_date column that start with the value of createdDate.
    List<Course> getCourseByCreatedDate(String createdDate);
    @Query(value = "Select * from Course where updated_date like CONCAT (?1, '%') ", nativeQuery = true) // nativeQuery you can use the variables in the sql
    List<Course> getCourseByUpdatedDate(String UpdatedDate);

    @Query(value = "SELECT c from Course c WHERE c.student.id = :id ")
    List<Course> getCourseByStudentId(@Param("id") Integer id);

    @Query(value = "SELECT c from Course c where c.isActive = true AND c.student.id =:id")
    List<Course> getAllActiveCoursesForAStudent(@Param("id") Integer id);

    @Query(value = "SELECT c from Course c where c.isActive = true")
    List<Course> getAllActiveCourses();

    @Modifying // enhance the query annotation.
    @Transactional // Use Method for database transaction, allows us to set propagation, isolation, timeout, read-only,
    // and rollback conditions and specify the transaction manager.

    @Query(value = "Update Course c Set c.isActive = false")
    void deleteAll();

    @Query(value = "select c from Course c where c.createdDate >=  :createdDate")
    List<Course> deleteAllCoursesCreatedAfterDate(Date createdDate);

    @Query(value = "select c from Course c where c.student.id = :studentId")
    List<Course> getCoursesByStudentId(@Param("studentId") Integer id);

    @Query(value = "select c from Course c where c.student.school.id = :schoolId")
    List<Course> getCoursesBySchoolId(@Param("schoolId") Integer schoolId);

    @Query("SELECT c.name from Course c")
// Write SQL query,  "s" can be any alphabet which is like static
    List<String> getAllCourseNames();






//    @Query("SELECT c from Course c where c.student.id= :studentId")
//        // :id is coming from the user
//        // using parameter for user input which is "SchoolID"
//    Course getStudentByCourseId(@Param("studentId") Integer id);    // whoever called the function and write the ID, it will be mapped with the ID of the school
//    // calling the function from the service


}
