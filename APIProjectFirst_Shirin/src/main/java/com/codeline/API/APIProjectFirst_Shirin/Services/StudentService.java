package com.codeline.API.APIProjectFirst_Shirin.Services;


import com.codeline.API.APIProjectFirst_Shirin.Models.School;
import com.codeline.API.APIProjectFirst_Shirin.Models.Student;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.SchoolRepository;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service // this is where everything is going to be done related to the object such as function and many more
// here is where the business logic is done
// To give controller whatever it needs
public class StudentService {
    // dependency injection...create a singleton (there is going to be one reference of student repository and whenever using it the program
    // it will not create a new object it will use the previous reference and give it/sprint going to provide the reference)
    @Autowired
    // creating reference of interface
            // create instance, and then it can be used in all the program
            StudentRepository studentRepository;
    @Autowired
    private SchoolRepository schoolRepository;

    // Creating aa function called addStudent
    public void addStudent() {
        // Creating object for the class student
        Student student = new Student();
        student.setName("Shirin");
        student.setRollNumber("1");
        // saving the data in the student interface
        studentRepository.save(student);
    }

   // Function that gets the student record by Id (getStudentById)
    public Student getStudentById(Integer id) {
        Student student = studentRepository.getStudentById(id); // getting the id from the user
        return student; //creating an empty course and returning it.

    }

    // Function that gets all the student (getAllStudent)
    public List<Student> getAllStudent() {
        return studentRepository.getAllStudent();
    }

    public void deleteStudentById(Integer Id) {
        // getting student by id and then putting it in an object
        Student StudentToDelete = studentRepository.findById(Id).get();
        studentRepository.delete(StudentToDelete);
    }

    //** Function the gets the student By the Name (getStudentByName)
    public Student getStudentByName(String student_name) {
        Student studentName = studentRepository.getStudentByName(student_name); // getting the student_name from the user
        return studentName;  //creating an empty school and returning it.
    }
    //**

    //** Function the gets the student By the school name (getStudentsBySchoolName)
    public List<Student> getStudentsBySchoolName(String schoolName) {
        School school = schoolRepository.getSchoolByName(schoolName); // get school by school name
        Integer schoolId = school.getId(); // getting the ID from school model and saving it into schoolId
        List<Student> studentList = studentRepository.getStudentsBySchoolId(schoolId);
        return studentList; // will return to whomever is calling the list which is the controller
    }
    //**

    // Function that gets all the active students (getAllActiveStudent)
    public List<Student> getAllActiveStudent(){
        return studentRepository.getAllActiveStudent();
    }

    // Function that gets all the not active students (getAllUnActiveStudent)
    public List<Student> getAllUnActiveStudent(){
        return studentRepository.getAllUnActiveStudent();
    }
    // Function that gets all the Latest Row of the student table (getStudentLatestRow)
    public List<Student> getStudentLatestRow(){
        return studentRepository.getStudentLatestRow();
    }

    // function that gets the latest update for student (getStudentLatestUpdated)
    public List<Student> getStudentLatestUpdated() {
        return studentRepository.getStudentLatestRow();
    }

    //function that checks if there is a date created bigger than the given date (getStudentCreatedAfterDate)
       public List<Student> getStudentCreatedAfterDate(String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(createdDate);
        List<Student> students = studentRepository.getStudentCreatedAfterDate(convertedDateFromStringToDateFormat);
        return students;
    }
}

