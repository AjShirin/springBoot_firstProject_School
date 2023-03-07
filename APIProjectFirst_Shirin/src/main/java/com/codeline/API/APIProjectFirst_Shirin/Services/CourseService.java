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

   //function that gets all courses by id (getCourseById)
    public Course getCourseById(Integer id) {
        Course course = courseRepository.getCourseById(id); // getting the id from the user
        return course; //creating an empty course and returning it.
    }

    //function that gets all the course (getAllCourse)
    public List<Course> getAllCourse() {
        return courseRepository.getAllCourse();
    }

    // function that gets all the active Course (getAllActiveCourse)
    public List<Course> getAllActiveCourse(){
        return courseRepository.getAllActiveCourse();
    }

    // function that gets all the  not active Courses (getAllUnActiveCourse)
    public List<Course> getAllUnActiveCourse(){
        return courseRepository.getAllUnActiveCourse();
    }

    // function that gets the Latest row of the Course (getCourseLatestRow)
    public List<Course> getCourseLatestRow() {
        return courseRepository.getCourseLatestRow();
    }










//    public Course getByCourseName(String courseName) {
//        Course course = courseRepository.getCourseByName(courseName);// get course by course name
//        Integer courseId = course.getId(); // getting the ID from course model and saving it into courseId
//         course = courseRepository.getCourseById(courseId);
//        return course; // will return to whomever is calling the list which is the controller
//    }



//  error
//    public Course getCourseByStudentName(String studentName) {
//        Course course = courseRepository.getCourseByName(studentName); // get course by course name
//        Integer courseId = course.getId(); // getting the ID from course model and saving it into courseId
//        Course courseList =courseRepository.getCourseById(courseId);
//        return courseList; // will return to whomever is calling the list which is the controller
//    }


}

//    public List<Course> getCourseByStudentName(String studentName) {
//        Course course = courseRepository.get
//                schoolRepository.getSchoolByName(studentName); // get school by school name
//        Integer schoolId = school.getId(); // getting the ID from school model and saving it into schoolId
//        List<Student> studentList = studentRepository.getStudentsBySchoolId(schoolId);
//        return studentList; // will return to whomever is calling the list which is the controller
//    }


