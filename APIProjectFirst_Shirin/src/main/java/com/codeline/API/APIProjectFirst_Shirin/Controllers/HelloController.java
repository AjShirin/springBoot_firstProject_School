package com.codeline.API.APIProjectFirst_Shirin.Controllers;

import com.codeline.API.APIProjectFirst_Shirin.Models.Course;
import com.codeline.API.APIProjectFirst_Shirin.Models.Student;
import com.codeline.API.APIProjectFirst_Shirin.Services.CourseService;
import com.codeline.API.APIProjectFirst_Shirin.Services.MarkService;
import com.codeline.API.APIProjectFirst_Shirin.Services.SchoolService;
import com.codeline.API.APIProjectFirst_Shirin.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// doing this tag to create a Restfull API (Used to create RESTful web services using Spring MVC.)
// controller speaking to the outside world
// If two combination is there it should be in "Hello Controller"
@RestController
public class HelloController {

    @Autowired // create instance, and then it can be used in all the program
    StudentService studentService;

    @Autowired // create instance, and then it can be used in all the program
    SchoolService schoolService;

    @Autowired // create instance, and then it can be used in all the program
    CourseService courseService;

    @Autowired // create instance, and then it can be used in all the program
    MarkService markService;


    @GetMapping
    public void addStudent() {
        studentService.addStudent();
    }

    @RequestMapping(value = "student/getStudentsBySchoolName", method = RequestMethod.GET)
    public List<Student> getStudentsBySchoolName(@RequestParam String schoolName) {
        return studentService.getStudentsBySchoolName(schoolName);
    }
//    error
//    @RequestMapping(value = "course/getCourseByStudentName", method = RequestMethod.GET)
//    public Course getCourseByStudentName(@RequestParam String studentName) {
//        return  courseService.getCourseByStudentName(studentName);
//    }

    // Ask the server to get something/ like Select
    // @GetMapping(name = "hello")
    // Creating a function that returns a string hello
    // public String helloPeople() {
    //  return "Hello";
    // }
    //@GetMapping(value = "deleteById") // inside the bracket is the endpoint
    //  public void


}
