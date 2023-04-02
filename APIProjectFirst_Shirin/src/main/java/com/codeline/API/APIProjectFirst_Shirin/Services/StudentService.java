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
import java.time.LocalDate;
import java.time.ZoneId;
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

//    public void deleteStudentById(Integer Id) {
//        // getting student by id and then putting it in an object
//        Student StudentToDelete = studentRepository.findById(Id).get();
//        studentRepository.delete(StudentToDelete);
//    }

    //** Function the gets the student By the Name (getStudentByName)
    public Student getStudentByName(String student_name) {
        Student studentName = studentRepository.getStudentByName(student_name); // getting the student_name from the user
        return studentName;  //creating an empty school and returning it.
    }
    //**

    // Function that gets all the active students (getAllActiveStudent)
    public List<Student> getAllActiveStudent() {
        return studentRepository.getAllActiveStudent();
    }

    // Function that gets all the not active students (getAllUnActiveStudent)
    public List<Student> getAllUnActiveStudent() {
        return studentRepository.getAllUnActiveStudent();
    }

    // Function that gets all the Latest Row of the student table (getStudentLatestRow)
    public List<Student> getStudentLatestRow() {
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

    // Function the gets the student By the school name (getStudentsBySchoolName)
    public List<Student> getStudentsBySchoolName(String schoolName) {
        School school = schoolRepository.getSchoolByName(schoolName); // get school by school name
        Integer schoolId = school.getId(); // getting the ID from school model and saving it into schoolId
        List<Student> studentList = studentRepository.getStudentsBySchoolId(schoolId);
        return studentList; // will return to whomever is calling the list which is the controller
    }

    // Function the gets the student By the roll Number (getByStudentByRollNumber)
    public Student getByStudentByRollNumber(Integer rollNumber) {
        Student student = studentRepository.getByStudentByRollNumber(rollNumber);
        return student;
    }

    // Function the gets the student By the school ID (getStudentsBySchoolId)
    public List<Student> getStudentsBySchoolId(Integer id) {
        List<Student> studentListId = studentRepository.getStudentsBySchoolId(id); // get school by school id
        return studentListId; // will return to whomever is calling the list which is the controller
    }

    // Function where it gets all the Student Created by the given Date (getStudentsByCreatedDate)
    public List<Student> getStudentsByCreatedDate(String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(createdDate);
        List<Student> students = studentRepository.getStudentsByCreatedDate(convertedDateFromStringToDateFormat);
        return students;
    }

    // Function where it gets all the Student Updated by the given Date (getStudentsByUpdatedDate)
    public List<Student> getStudentsByUpdatedDate(String UpdatedDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(UpdatedDate);
        List<Student> studentsUpdatedDate = studentRepository.getStudentsByUpdatedDate(convertedDateFromStringToDateFormat);
        return studentsUpdatedDate;
    }

    // This function updates the 'isActive' column to false by the Student ID (deleteStudentById)
    public void deleteStudentById(Integer id) {
        Student student = studentRepository.getStudentById(id);
        student.setIsActive(Boolean.FALSE);
        studentRepository.save(student);
    }

    // This function updates all the student 'isActive' column to false (deleteAllStudents)
    public void deleteAllStudents() {
        studentRepository.deleteAllStudents();
    }

    //This function updates the 'isActive' column to false by giving the Created date (deleteAllStudentsCreatedAfterDate)
    public void deleteAllStudentsCreatedAfterDate(String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(createdDate);
        List<Student> studentsCreatedDate = studentRepository.getStudentsByCreatedDate(convertedDateFromStringToDateFormat);
        studentsCreatedDate.stream().forEach(create -> create.setIsActive(Boolean.FALSE));
        studentRepository.saveAll(studentsCreatedDate);
    }

    // This function updates the 'isActive' column to false by giving the student name (deleteByStudentName)
    public String deleteByStudentName(String name) {
        Student student = studentRepository.getStudentByName(name);
        if (student != null) {
            if (student.getIsActive()) {
                student.setIsActive(false);
                studentRepository.save(student);
                return "Student with name " + name + " has been deactivated Successfully :)";
            } else {
                return "Student with name " + name + " is already deactivated :)";
            }
        } else {
            return "Student with name " + name + " is not found in the database :(";
        }
    }
    //deleteByStudentByRollNumber

    //deleteStudentsBySchoolId

    //This function updates the 'isActive' column to false by giving the Created date (deleteStudentsByCreatedDate)
    public String deleteStudentsByCreatedDate(String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(createdDate);
        List<Student> students = studentRepository.getStudentsByCreatedDate(convertedDateFromStringToDateFormat);
        if (students.isEmpty()) {
            return "Date doesn't exist in the database, Try again :(";
        } else {
            for (Student student : students) {
                if (!student.getIsActive()) {
                    return "The record is already deactivated :)";
                }
                student.setIsActive(Boolean.FALSE);
            }
            studentRepository.saveAll(students);
            return "Record deleted successfully :)";
        }
    }

    //This function updates the 'isActive' column to false by giving the Updated date (deleteStudentsByUpdatedDate)
    public String deleteStudentsByUpdatedDate(String UpdatedDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(UpdatedDate);
        List<Student> studentsUpdatedDate = studentRepository.getStudentsByUpdatedDate(convertedDateFromStringToDateFormat);
        if (studentsUpdatedDate.isEmpty()) {
            return "Date doesn't exist in the database, Try again :(";
        } else {
            for (Student student : studentsUpdatedDate) {
                if (!student.getIsActive()) {
                    return "The record is already deactivated :)";
                }
                student.setIsActive(Boolean.FALSE);
            }
            studentRepository.saveAll(studentsUpdatedDate);
            return "Record deleted successfully :)";
        }
    }

    // Function that creates a new student record (createStudent)
    public String createStudent(String name) {
        try {
            Student student = new Student();
            student.setName(name);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date createdDate = formatter.parse("2022-03-03");
            student.setCreatedDate(createdDate);
            student.setUpdatedDate(new Date());
            student.setIsActive(Boolean.TRUE);
            studentRepository.save(student);
            return "New student added successfully :)";
        } catch (Exception e) {
            return "An error occurred, record is not added. Please try again.";
        }
    }

    //update Student (whole row) [updateStudent]
    public String updateStudent(Integer id, String name, Boolean isActive, String userCreatedDate, String userUpdatedDate) {
        try {
            Student student = studentRepository.getStudentById(id);
            student.setName(name);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date createdDate = formatter.parse(userCreatedDate);
            Date updatedDate = formatter.parse(userUpdatedDate);
            student.setCreatedDate(createdDate);
            student.setUpdatedDate(updatedDate);
            student.setIsActive(isActive);
            studentRepository.save(student);
            return "The record of ID number:" + id + " has been successfully updated :)";
        } catch (Exception e) {
            return "An error occurred, record is not updated. Please try again.";
        }
    }


}


