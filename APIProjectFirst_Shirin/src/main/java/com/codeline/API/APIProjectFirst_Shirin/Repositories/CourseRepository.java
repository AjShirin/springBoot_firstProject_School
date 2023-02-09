package com.codeline.API.APIProjectFirst_Shirin.Repositories;

import com.codeline.API.APIProjectFirst_Shirin.Models.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // Collection of code that is going to be used for the Objects
// The class is dealing with student and the primary key in Integer
// using inheritance
public interface CourseRepository extends CrudRepository<Course,Integer> {
}
