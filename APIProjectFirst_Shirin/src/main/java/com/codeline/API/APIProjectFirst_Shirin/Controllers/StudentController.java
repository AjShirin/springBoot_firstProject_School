package com.codeline.API.APIProjectFirst_Shirin.Controllers;


import com.codeline.API.APIProjectFirst_Shirin.Models.Student;
import com.codeline.API.APIProjectFirst_Shirin.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // Calls the function that checks if there is a date created bigger than the given date (getStudentCreatedAfterDate)
    @RequestMapping(value = "/getStudentCreatedAfterDate", method = RequestMethod.GET)
    public List<Student> getStudentCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<Student> createdAfterDateStudent = studentService.getStudentCreatedAfterDate(createdDate);
        return createdAfterDateStudent;
    }

    // Calls the function the gets the student By the Name (getStudentByName)
    @RequestMapping(value = "/getByStudentName", method = RequestMethod.GET)
    public Student getStudentByName(@RequestParam String student_name) {  //The student_name is the same variable as the sql
        Student studentName = studentService.getStudentByName(student_name);
        return studentName;
    }

    // Class the function the gets the student by the Roll Number (getByStudentByRollNumber)
//    @RequestMapping(value = "getByStudentByRollNumber", method = RequestMethod.GET)
//    public Student getByStudentByRollNumber(@RequestParam Integer studentRollNumber) {
//        Student rollNumberStudent = studentService.getByStudentByRollNumber(studentRollNumber);
//        return rollNumberStudent;
//    }

    // Calls the function the gets the student By School ID (getStudentsBySchoolId)
    @RequestMapping(value = "/getStudentsBySchoolId", method = RequestMethod.GET)
    public List<Student> getStudentsBySchoolId(@RequestParam Integer id) throws ParseException {
        List<Student> schoolIdForStudent = studentService.getStudentsBySchoolId(id);
        return schoolIdForStudent;
    }

    // Calls the function where it gets all the Student Created by the given Date (getStudentsByCreatedDate)
    @RequestMapping(value = "/getStudentsByCreatedDate", method = RequestMethod.GET)
    public List<Student> getSchoolByCreatedDate(String createdDate) throws ParseException {
        List<Student> getStudentByCreatedDateVariable = studentService.getStudentsByCreatedDate(createdDate);
        return getStudentByCreatedDateVariable;
    }

    // Calls the function where it gets all the Student Updated by the given Date (getStudentsByUpdatedDate)
    @RequestMapping(value = "/getStudentsByUpdatedDate", method = RequestMethod.GET)
    public List<Student> getStudentsByUpdatedDate(String UpdatedDate) throws ParseException {
        List<Student> getStudentByUpdatedDateVariable = studentService.getStudentsByUpdatedDate(UpdatedDate);
        return getStudentByUpdatedDateVariable;
    }

    // This function updates the 'isActive' column to false by the Student ID (deleteStudentById)
    @RequestMapping(value = "/deleteStudentById")
    public void deleteStudentById(Integer id) {
        studentService.deleteStudentById(id);
    }

    // This function updates all the student 'isActive' column to false (deleteAllStudents)
    @RequestMapping(value = "/deleteAllStudents")
    public void deleteAllStudents() {
        studentService.deleteAllStudents();
    }

    //This function updates the 'isActive' column to false by giving the Created date (deleteAllStudentsCreatedAfterDate)
    @RequestMapping(value = "/deleteAllStudentsCreatedAfterDate", method = RequestMethod.POST)
    public String deleteAllStudentsCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        try {
            studentService.deleteAllStudentsCreatedAfterDate(createdDate);
        } catch (ParseException e) {
            return "Failed to delete try again...";
        }
        return "Deleted Successfully :)";
    }

    //This function updates the 'isActive' column to false by giving the Student name (deleteByStudentName)
    @RequestMapping(value = "/deleteByStudentName", method = RequestMethod.POST)
    public ResponseEntity<String> deleteByStudentName(@RequestParam String name) { // ResponseEntity<String> represents an HTTP,
        // response with a body of type String, that returns response from a controller,and allows us to customize the HTTP response status.
        String response = studentService.deleteByStudentName(name);
        if (response.contains("not found") || response.contains("is not found")) {
            return ResponseEntity.badRequest().body(response);
        } else if (response.contains("already deactivated")) {
            return ResponseEntity.badRequest().body(response);
        } else {
            return ResponseEntity.ok(response);
        }
    }

    //This function updates the 'isActive' column to false by giving the Created date (deleteStudentsByCreatedDate)
    @RequestMapping(value = "/deleteStudentsByCreatedDate", method = RequestMethod.POST)
    public ResponseEntity<String> deleteStudentsByCreatedDate(@RequestParam String createdDate) { // ResponseEntity<String> represents an HTTP,
        // response with a body of type String, that returns response from a controller,and allows us to customize the HTTP response status.
        try {
            String response = studentService.deleteStudentsByCreatedDate(createdDate);
            return ResponseEntity.ok(response);
        } catch (ParseException e) {
            return ResponseEntity.badRequest().body("Invalid date format :( Try again");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting students :(");
        }
    }

    //This function updates the 'isActive' column to false by giving the Updated date (deleteStudentsByUpdatedDate)
    @RequestMapping(value = "/deleteStudentsByUpdatedDate", method = RequestMethod.POST)
    public ResponseEntity<String> deleteStudentsByUpdatedDate(@RequestParam String UpdatedDate) { // ResponseEntity<String> represents an HTTP,
        // response with a body of type String, that returns response from a controller,and allows us to customize the HTTP response status.
        try {
            String response = studentService.deleteStudentsByUpdatedDate(UpdatedDate);
            return ResponseEntity.ok(response);
        } catch (ParseException e) {
            return ResponseEntity.badRequest().body("Invalid date format :( Try again");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting students :(");
        }
    }

    // This function creates new record for student with user Input (createStudent)
    @RequestMapping(value = "/createStudent", method = RequestMethod.POST)
    public ResponseEntity<String> createStudent( @RequestParam String name) { // ResponseEntity<String> represents an HTTP,
        // response with a body of type String, that returns response from a controller,and allows us to customize the HTTP response status.
        try {
            studentService.createStudent(name);
            return ResponseEntity.status(HttpStatus.CREATED).body("New student added successfully :)");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred, record is not added. Please try again.");
        }
    }



}






