package com.codeline.API.APIProjectFirst_Shirin.Services;

import com.codeline.API.APIProjectFirst_Shirin.Models.School;
import com.codeline.API.APIProjectFirst_Shirin.Models.Student;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.SchoolRepository;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // this is where everything is going to be done related to the object such as function and many more
public class StudentService {
    // dependency injection...create a singleton (there is going to be one reference of student repository and whenever using it the program
    // it will not create a new object it will use the previous reference and give it/sprint going to provide the reference)
    @Autowired
    // creating reference of interface
            // create instance, and then it can be used in all the program
            StudentRepository studentRepository;

    // Creating aa function called addStudent
    public void addStudent() {
        // Creating object for the class student
        Student student = new Student();
        student.setName("Shirin");
        student.setRollNumber("1");
        // saving the data in the student interface
        studentRepository.save(student);
    }


    //function that gets all the student
    public List<Student> getAllStudent() {
        return studentRepository.getAllStudent();
    }

        public void deleteStudentById (Integer Id){
            // getting student by id and then putting it in an object
            Student StudentToDelete = studentRepository.findById(Id).get();
            studentRepository.delete(StudentToDelete);
        }

    }

