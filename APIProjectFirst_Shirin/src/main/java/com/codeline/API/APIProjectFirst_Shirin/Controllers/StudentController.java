package com.codeline.API.APIProjectFirst_Shirin.Controllers;


import com.codeline.API.APIProjectFirst_Shirin.Models.Student;
import com.codeline.API.APIProjectFirst_Shirin.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// since we put @RequestMapping for the class in the top , so there is no need to add it in @RequestMapping  for function
//ex:  @RequestMapping(value = "Customer")
//@RequestMapping(value = "/getIsActive", method = RequestMethod.GET)

@RestController
@RequestMapping(value = "student")
// Any request coming form browser that is related to student it will be mapped with this class
public class StudentController {

    @Autowired // create instance, and then it can be used in all the program //like object chaining
    // if we remove the auto wire it will return null because there is no value
    // (if you don't want to use @Autowire you can do SchoolService schoolService = new SchoolService --> this is called injection dependency )
    // for school controller to work , school service should work since they are dependent on each other
    StudentService studentService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    //function that returns all student
    public List<Student> getAllStudent() { // This will take from the browser and then return in the browser
        List<Student> students = studentService.getAllStudent(); // changing the list to the function because instead of we
        //initialize empty list and then insert data we directly inserted a data.
        return students;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET) // "student/getById" is a prefix
    public Student getStudentById(@RequestParam Integer studentId) { //Request Parameter gets the parameter you want
        // Student student = new Student(); // creating an empty school
        //Student student = studentService.getStudentById(studentId); // so the school will return school = schoolService.getSchoolById(id)
        Student student = studentService.getStudentById(studentId);
        return student;
    }

    @RequestMapping(value = "/getByStudentName", method = RequestMethod.GET)
    public Student getStudentByName(@RequestParam String student_name) {  //The student_name is the same variable as the sql
        Student studentName = studentService.getStudentByName(student_name);
        return studentName;
    }

    @RequestMapping(value = "/getAllStudentByIsActive")
    public List<Student> getAllActiveStudent() {
        List<Student> activeStudentList = studentService.getAllActiveStudent();
        return activeStudentList;
    }

    @RequestMapping(value = "/getAllStudentByIsUnActive")
    public List<Student> getAllUnActiveStudent() {
        List<Student> notActiveStudentList = studentService.getAllUnActiveStudent();
        return notActiveStudentList;
    }

    @RequestMapping(value = "/getStudentLatestRow")
    public List<Student> getStudentLatestRow() {
        List<Student> studentLatestRowList = studentService.getStudentLatestRow();
        return studentLatestRowList;
    }

}
