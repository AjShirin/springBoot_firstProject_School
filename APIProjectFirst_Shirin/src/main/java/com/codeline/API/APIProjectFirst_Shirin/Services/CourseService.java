package com.codeline.API.APIProjectFirst_Shirin.Services;

import com.codeline.API.APIProjectFirst_Shirin.Models.Course;
import com.codeline.API.APIProjectFirst_Shirin.Models.School;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // this is where everything is going to be done related to the object such as function and many more
// here is where the business logic is done
// To give controller whatever it needs
public class CourseService {

    @Autowired // create instance, and then it can be used in all the program
    CourseRepository courseRepository;


    //function that gets all the school
    public List<Course> getAllCourse() {
        return courseRepository.getAllCourse();
    }

    public Course getCourseById(Integer id) {
        Course course = courseRepository.getCourseById(id); // getting the id from the user
        return course; //creating an empty course and returning it.

    }

}

