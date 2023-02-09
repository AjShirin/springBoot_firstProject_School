package com.codeline.API.APIProjectFirst_Shirin.Controllers;

import com.codeline.API.APIProjectFirst_Shirin.Models.Course;
import com.codeline.API.APIProjectFirst_Shirin.Models.School;
import com.codeline.API.APIProjectFirst_Shirin.Models.Student;
import com.codeline.API.APIProjectFirst_Shirin.Services.CourseService;
import com.codeline.API.APIProjectFirst_Shirin.Services.SchoolService;
import com.codeline.API.APIProjectFirst_Shirin.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// doing this tag to create a Restfull API
@RestController
public class HelloController {

    @Autowired // create instance, and then it can be used in all the program
    StudentService studentService;

    @Autowired // create instance, and then it can be used in all the program
    SchoolService schoolService;

    @Autowired // create instance, and then it can be used in all the program
    CourseService courseService;


    @GetMapping
    public void addStudent() {
        studentService.addStudent();
    }
    

    // general form of request handling and define the method should that can be get
    @RequestMapping(value = "school/getAll", method = RequestMethod.GET)
    //function that returns all school
    public List<School> getAllSchools()  { // This will take from the browser and then return in the browser
        List<School> schools = schoolService.getAllSchools(); // changing the list to the function because instead of we
        //initialize empty list and then insert data we directly inserted a data.
        return schools;
    }

    @RequestMapping(value = "student/getAll", method = RequestMethod.GET)
    //function that returns all student
    public List<Student> getAllStudent()  { // This will take from the browser and then return in the browser
        List<Student> students = studentService.getAllStudent() ; // changing the list to the function because instead of we
        //initialize empty list and then insert data we directly inserted a data.
        return students;
    }

    @RequestMapping(value = "course/getAll", method = RequestMethod.GET)
    //function that returns all student
    public List<Course> getAllCourse()  { // This will take from the browser and then return in the browser
        List<Course> course = courseService.getAllCourse() ; // changing the list to the function because instead of we
        //initialize empty list and then insert data we directly inserted a data.
        return course;
    }

    // Ask the server to get something/ like Select
    // @GetMapping(name = "hello")
    // Creating a function that returns a string hello
    // public String helloPeople() {
    //  return "Hello";
    // }
    //@GetMapping(value = "deleteById") // inside the bracket is the endpoint
    //  public void


}
