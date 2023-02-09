package com.codeline.API.APIProjectFirst_Shirin.Repositories;

import com.codeline.API.APIProjectFirst_Shirin.Models.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Collection of code that is going to be used for the Objects
// The class is dealing with student and the primary key in Integer
// using inheritance
public interface SchoolRepository extends CrudRepository<School, Integer> {
    @Query("SELECT s from School s")
// Write SQL query,  "s" can be any alphabet which is like static
    List<School> getAllSchools();
}
