package com.codeline.API.APIProjectFirst_Shirin.Controllers;

import com.codeline.API.APIProjectFirst_Shirin.Models.Course;
import com.codeline.API.APIProjectFirst_Shirin.Models.Mark;
import com.codeline.API.APIProjectFirst_Shirin.Models.School;
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


    // general form of request handling and define the method should that can be get
    @RequestMapping(value = "school/getAll", method = RequestMethod.GET)
    //function that returns all school
    public List<School> getAllSchools() { // This will take from the browser and then return in the browser
        List<School> schools = schoolService.getAllSchools(); // changing the list to the function because instead of we
        //initialize empty list and then insert data we directly inserted a data.
        return schools;
    }

    @RequestMapping(value = "student/getAll", method = RequestMethod.GET)
    //function that returns all student
    public List<Student> getAllStudent() { // This will take from the browser and then return in the browser
        List<Student> students = studentService.getAllStudent(); // changing the list to the function because instead of we
        //initialize empty list and then insert data we directly inserted a data.
        return students;
    }

    @RequestMapping(value = "course/getAll", method = RequestMethod.GET)
    //function that returns all student
    public List<Course> getAllCourse() { // This will take from the browser and then return in the browser
        List<Course> course = courseService.getAllCourse(); // changing the list to the function because instead of we
        //initialize empty list and then insert data we directly inserted a data.
        return course;
    }

    @RequestMapping(value = "Mark/getAll", method = RequestMethod.GET)
    //function that returns all student
    public List<Mark> getAllMarks() { // This will take from the browser and then return in the browser
        List<Mark> mark = markService.getAllMarks(); // changing the list to the function because instead of we
        //initialize empty list and then insert data we directly inserted a data.
        return mark;
    }

    @RequestMapping(value = "school/getById", method = RequestMethod.GET) // "school/getById" is a prefix
    public School getSchoolById(@RequestParam Integer schoolId) { //Request Parameter gets the parameter you want
        // School school = new School(); // creating an empty school
        //schoolService.getSchoolById(schoolId); // so the school will return school = schoolService.getSchoolById(id)
        School school = schoolService.getSchoolById(schoolId);
        return school;
    }

    @RequestMapping(value = "course/getById", method = RequestMethod.GET) // "course/getById" is a prefix
    public Course getCourseById(@RequestParam Integer courseId) { //Request Parameter gets the parameter you want
        // Course course = new Course(); // creating an empty school
        //courseService.getCourseById(courseId); // so the school will return school = schoolService.getSchoolById(id)
        Course course = courseService.getCourseById(courseId);
        return course;
    }

    @RequestMapping(value = "mark/getById", method = RequestMethod.GET) // "mark/getById" is a prefix
    public Mark getMarkById (@RequestParam Integer markId) { //Request Parameter gets the parameter you want
        // Mark mark = new Mark(); // creating an empty school
        //Mark mark = markService.getMarkById(markId); // so the school will return school = schoolService.getSchoolById(id)
        Mark mark = markService.getMarkById(markId);
        return mark;
    }

    @RequestMapping(value = "student/getById", method = RequestMethod.GET) // "student/getById" is a prefix
    public Student getStudentById (@RequestParam Integer studentId) { //Request Parameter gets the parameter you want
        // Student student = new Student(); // creating an empty school
        //Student student = studentService.getStudentById(studentId); // so the school will return school = schoolService.getSchoolById(id)
        Student student = studentService.getStudentById(studentId);
        return student;
    }

    @RequestMapping(value = "school/getBySchoolName", method = RequestMethod.GET)
    public School getSchoolByName (@RequestParam String school_name) {
        School schoolName = schoolService.getSchoolByName(school_name);
        return schoolName;
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
