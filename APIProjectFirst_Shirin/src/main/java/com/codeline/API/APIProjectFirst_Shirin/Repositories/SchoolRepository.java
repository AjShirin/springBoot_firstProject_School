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
public interface SchoolRepository extends CrudRepository<School, Integer> {
    @Query("SELECT sch from School sch")
// Write SQL query,  "s" can be any alphabet which is like static
    List<School> getAllSchools();

    // Write SQL query,  "s" can be any alphabet which is like static
    // s is like alias
    @Query("SELECT sch from School sch where sch.id= :schoolId")
    // :id is coming from the user
    // using parameter for user input which is "SchoolID"
    School getSchoolById(@Param("schoolId") Integer id); // mapping the query and returning the school
    // whoever called the function and write the ID, it will be mapped with the ID of the school
    // calling the function from the service


    @Query("SELECT sch from School sch where sch.name= :schoolName")
        // the verifiable should
    School getSchoolByName(@Param("schoolName") String school_name); // mapping the query and returning the school

    @Query(value = "SELECT sch from School sch where sch.isActive = true")
    List<School> getAllActiveSchools();

    @Query(value = "SELECT sch from School sch where sch.isActive = false")
    List<School> getAllUnActiveSchools();

    @Query(value = "SELECT sch from School sch where sch.id = (SELECT Max(sch.id) FROM School sch)")
    List<School> getSchoolLatestRow();

    @Query(value = "SELECT sch from School sch where sch.UpdatedDate = (SELECT MAX(sch.UpdatedDate) FROM School sch)")
    List<School> getSchoolLatestUpdated();

    @Query("SELECT sch from School sch where sch.createdDate >= :createdDate")
    List<School> getSchoolCreatedAfterDate(Date createdDate);

    @Query("SELECT sch from School sch where sch.createdDate = :createdDate")
    List<School> getSchoolByCreatedDate (Date createdDate);

    @Modifying // enhance the query annotation.
    @Transactional // Use Method for database transaction, allows us to set propagation, isolation, timeout, read-only,
    // and rollback conditions and specify the transaction manager.
    @Query(value = "Update School sch Set sch.isActive = false")
    void deleteAllSchool();


    @Query(value = "Select * from school where updated_date like CONCAT (?1, '%') ", nativeQuery = true) // nativeQuery you can use the variables in the sql
    List<School> getSchoolByUpdatedDate(String UpdatedDate);


}
