package com.codeline.API.APIProjectFirst_Shirin.Controllers;


import com.codeline.API.APIProjectFirst_Shirin.Models.School;
import com.codeline.API.APIProjectFirst_Shirin.Models.Student;
import com.codeline.API.APIProjectFirst_Shirin.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
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

    // Calls the function that gets the student record by Id (getStudentById)
    @RequestMapping(value = "/getById", method = RequestMethod.GET) // "student/getById" is a prefix
    public Student getStudentById(@RequestParam Integer studentId) { //Request Parameter gets the parameter you want
        // Student student = new Student(); // creating an empty school
        //Student student = studentService.getStudentById(studentId); // so the school will return school = schoolService.getSchoolById(id)
        Student student = studentService.getStudentById(studentId);
        return student;
    }

    // calls the function that gets all the student (getAllStudent)
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    //function that returns all student
    public List<Student> getAllStudent() { // This will take from the browser and then return in the browser
        List<Student> students = studentService.getAllStudent(); // changing the list to the function because instead of we
        //initialize empty list and then insert data we directly inserted a data.
        return students;
    }
    //** Class the function the gets the student By the Name (getStudentByName)
    @RequestMapping(value = "/getByStudentName", method = RequestMethod.GET)
    public Student getStudentByName(@RequestParam String student_name) {  //The student_name is the same variable as the sql
        Student studentName = studentService.getStudentByName(student_name);
        return studentName;
    }
    //*****

    // Calls the function that gets all the active students (getAllStudentByIsActive)
    @RequestMapping(value = "/getAllStudentByIsActive")
    public List<Student> getAllActiveStudent() {
        List<Student> activeStudentList = studentService.getAllActiveStudent();
        return activeStudentList;
    }

    // Calls the function that gets all the not active students (getAllStudentByIsUnActive)
    @RequestMapping(value = "/getAllStudentByIsUnActive")
    public List<Student> getAllUnActiveStudent() {
        List<Student> notActiveStudentList = studentService.getAllUnActiveStudent();
        return notActiveStudentList;
    }
    // Calls the function that gets the latest row of students (getStudentLatestRow)
    @RequestMapping(value = "/getStudentLatestRow")
    public List<Student> getStudentLatestRow() {
        List<Student> studentLatestRowList = studentService.getStudentLatestRow();
        return studentLatestRowList;
    }

    // Calls the function of the latest update for school (getStudentLatestUpdated)
    @RequestMapping(value = "/getStudentLatestUpdated")
    public List<Student> getStudentLatestUpdated() {
        List<Student> studentLatestUpdatedList = studentService.getStudentLatestUpdated();
        return studentLatestUpdatedList;
    }

    //function that checks if there is a date created bigger than the given date (getStudentCreatedAfterDate)
    @RequestMapping(value = "/getStudentCreatedAfterDate", method = RequestMethod.GET)
    public List<Student> getStudentCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<Student> createdAfterDateStudent = studentService.getStudentCreatedAfterDate(createdDate);
        return createdAfterDateStudent;
    }

}
