package com.codeline.API.APIProjectFirst_Shirin.Repositories;

import com.codeline.API.APIProjectFirst_Shirin.Models.Course;
import com.codeline.API.APIProjectFirst_Shirin.Models.Mark;
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
public interface MarkRepository extends JpaRepository<Mark, Integer> {

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

    @Query(value = "SELECT m from Mark m where m.isActive = true")
    List<Mark> getAllActiveMark();

    @Query(value = "SELECT m from Mark m where m.isActive = false")
    List<Mark> getAllUnActiveMark();

    @Query(value = "SELECT m from Mark m where m.id = (SELECT Max(m.id) FROM Mark m)")
    List<Mark> getLatestRow();

    @Query(value = "SELECT m from Mark m where m.UpdatedDate = (SELECT MAX(m.UpdatedDate) FROM Mark m)")
    List<Mark> getLatestUpdated();

    @Query("SELECT m from Mark m where m.createdDate >= :createdDate")
    List<Mark> getMarksCreatedAfterDate(Date createdDate);

    @Query(value = "SELECT m FROM Mark m WHERE m.grade =:grade")
    List<Mark> getAllByGrade(@Param("grade") String grade);

    @Query(value = "SELECT m FROM Mark m WHERE m.obtainMark >:obtainMark")
    List<Mark> getByObtainedMarksMoreThan(@Param("obtainMark") Integer obtainMark);

    @Query(value = "SELECT m FROM Mark m WHERE m.obtainMark <:obtainMark")
    List<Mark> getByObtainedMarksLessThan(@Param("obtainMark") Integer obtainMark);


    @Query("SELECT m from Mark m where m.UpdatedDate = :UpdatedDate")
    List<Mark> getMarksByUpdatedDate(Date UpdatedDate);

    @Query(value = "SELECT m from Mark m WHERE m.course.id = :id ")
    List<Mark> getMarksByCourseId(@Param("id") Integer id);

    @Modifying
    @Transactional

    @Query(value = "Update Mark m Set m.isActive = false")
    void deleteAllMarks();

//    @Query(value = "UPDATE Mark m SET m.isActive = false WHERE m.course.id= :courseId")
//    Mark deleteMarksByCourseId(@Param("courseId") Integer courseId);

    @Query(value = "select avg(m.obtainMark) from Mark m where m.course.name = :courseName ")
    Integer getAverageMarksByCourseName(@Param("courseName") String courseName);

    @Query(value = "select sum(m.obtainMark) from Mark m where m.course.student.id  = :studentId ")
    Integer getSumOfMarksByStudentId(@Param("studentId") Integer studentId);

    @Query(value = "select avg(m.obtainMark) from Mark m where m.course.student.id = :studentId ")
    Integer getAvgMarkByStudentId(@Param("studentId") Integer studentId);
    @Query(value = "select Distinct(m.grade) from Mark m ")
    List<String> getDistinctGrades();

    @Query(value = "select count(m) from Mark m where m.course.name = :courseName And m.grade = :grade ")
    Integer getTotalMarksByGradeAndCourseName( @Param("courseName") String courseName,@Param("grade") String grade);

    @Query(value = "select avg(m.obtainMark) from Mark m where m.course.id = :courseId ")
    Integer averageMarkForCourse(@Param("courseId") Integer courseId);




}

