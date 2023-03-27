package com.codeline.API.APIProjectFirst_Shirin.Repositories;



import com.codeline.API.APIProjectFirst_Shirin.Models.School;
import com.codeline.API.APIProjectFirst_Shirin.Models.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.Date;
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

    // the 'name' should be the same as the java
    @Query("SELECT s from Student s where s.name= :name")
    // mapping the query and returning the student
    Student getStudentByName(@Param("name") String student_name);
// To do in the postman localhost:8080/student/getByStudentName?student_name(sql column)=shirin

    @Query(value = "SELECT std from Student std WHERE std.school.id = :id ")
    List<Student> getStudentsBySchoolId(@Param("id") Integer id);

    @Query(value = "SELECT std from Student std where std.isActive = true")
    List<Student> getAllActiveStudent();

    @Query(value = "SELECT std from Student std where std.isActive = false")
    List<Student> getAllUnActiveStudent();

    @Query(value = "SELECT std from Student std where std.id = (SELECT Max(std.id) FROM Student std)")
    List<Student> getStudentLatestRow();

    @Query(value = "SELECT DISTINCT(school_id) FROM student", nativeQuery = true)
    List<Integer> getDistinctSchoolIdsFromStudent();

    @Query(value = "SELECT COUNT(id) From student where school_id = ?1", nativeQuery = true)
    Integer getCountOfStudentsBySchoolId(Integer schoolId);

    @Query("SELECT s from Student s where s.createdDate >= :createdDate")
    List<Student> getStudentCreatedAfterDate(Date createdDate);

    @Query("SELECT s from Student s where s.createdDate = :createdDate")
    List<Student> getStudentsByCreatedDate(Date createdDate);

    @Query("SELECT s from Student s where s.UpdatedDate = :UpdatedDate")
    List<Student> getStudentsByUpdatedDate(Date UpdatedDate);

    @Modifying // enhance the query annotation.
    @Transactional // Use Method for database transaction, allows us to set propagation, isolation, timeout, read-only,
    // and rollback conditions and specify the transaction manager.
    
    @Query(value = "Update Student s Set s.isActive = false")
    void deleteAllStudents();



}