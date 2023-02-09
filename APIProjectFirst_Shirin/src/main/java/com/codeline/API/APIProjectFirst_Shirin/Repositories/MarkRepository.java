package com.codeline.API.APIProjectFirst_Shirin.Repositories;

import com.codeline.API.APIProjectFirst_Shirin.Models.Mark;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Collection of code that is going to be used for the Objects
// The class is dealing with student and the primary key in Integer
// using inheritance
public interface MarkRepository extends CrudRepository<Mark,Integer> {

    @Query("SELECT m from Mark m")
// Write SQL query,  "m" can be any alphabet which is like static
    List<Mark> getAllMarks();
}
