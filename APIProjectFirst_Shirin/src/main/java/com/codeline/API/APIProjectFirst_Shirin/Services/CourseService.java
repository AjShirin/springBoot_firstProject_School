package com.codeline.API.APIProjectFirst_Shirin.Services;

import com.codeline.API.APIProjectFirst_Shirin.Models.Course;
import com.codeline.API.APIProjectFirst_Shirin.Models.Student;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.CourseRepository;
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
    public List<Course> getAllActiveCourse() {
        return courseRepository.getAllActiveCourse();
    }

    // function that gets all the  not active Courses (getAllUnActiveCourse)
    public List<Course> getAllUnActiveCourse() {
        return courseRepository.getAllUnActiveCourse();
    }

    // function that gets the Latest row of the Course (getCourseLatestRow)
    public List<Course> getCourseLatestRow() {
        return courseRepository.getCourseLatestRow();
    }

    // function that gets the latest update for Course (getCourseLatestUpdated)
    public List<Course> getCourseLatestUpdated() {
        return courseRepository.getCourseLatestUpdated();
    }

    //function that checks if there is a date created bigger than the given date (getCourseCreatedAfterDate)
    public List<Course> getCourseCreatedAfterDate(String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(createdDate);
        List<Course> course = courseRepository.getSchoolCreatedAfterDate(convertedDateFromStringToDateFormat);
        return course;
    }

    // function that gets the Course by the name (getByCourseName)
    public List<Course> getCoursesByName(String courseName) {
        List<Course> courseNameVariable = courseRepository.getByCourseName(courseName); // getting the courseName from the user
        return courseNameVariable; //creating an empty course and returning it.
    }

    // Function where it gets all the Course Created by the given Date (getCourseByCreatedDate)
    public List<Course> getCourseByCreatedDate(String createdDate) {
        List<Course> course = courseRepository.getCourseByCreatedDate(createdDate);
        return course;
}

    // Function that gets all course create by the given updated date (getCourseByUpdatedDate)
    public List<Course> getCourseByUpdatedDate(String UpdatedDate) {
        List<Course> course = courseRepository.getCourseByUpdatedDate(UpdatedDate);
        return course;
    }


    // Function that gets all courses from the student ID (getCourseByStudentId)
    public List<Course> getCourseByStudentId(Integer studentId){
        List<Course> courseList = courseRepository.getCourseByStudentId(studentId);
        return courseList;
    }

    //Function that gets all courses that are active (getAllActiveCoursesForAStudent)
    public List<Course> getAllActiveCoursesForAStudent(Integer studentId){
        return courseRepository.getAllActiveCoursesForAStudent(studentId);
    }

    // function that gets all the active course (getAllActiveCourses)
    public List<Course> getAllActiveCourses() {
        return courseRepository.getAllActiveCourses();
    }

    // This function updates the 'isActive' column to false by the course ID (deleteById)
    public void deleteById(Integer id) {
        Course course = courseRepository.getCourseById(id);
        course.setIsActive(Boolean.FALSE);
        courseRepository.save(course);
    }

    // This function updates all the course 'isActive' column to false (deleteAll)
    public void deleteAll() {
        courseRepository.deleteAll();
    }

    // This function updates all courses that is greater than the given created date (deleteAllCoursesCreatedAfterDate)
    public void deleteAllCoursesCreatedAfterDate(String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(createdDate);
        List<Course> course = courseRepository.deleteAllCoursesCreatedAfterDate(convertedDateFromStringToDateFormat);
        course.stream().forEach(x -> x.setIsActive(Boolean.FALSE));
        courseRepository.saveAll(course);
    }

    // This function updates the 'isActive' column to false by giving the course name (deleteByCourseName)
    public void deleteCoursesByName(String courseName) {
        List<Course> course = courseRepository.getByCourseName(courseName);
        course.stream().forEach(x -> x.setIsActive(Boolean.FALSE));
        courseRepository.saveAll(course);
    }

    //This function updates the 'isActive' column to false by giving the Created date (deleteCoursesByCreatedDate)
    public void deleteCoursesByCreatedDate(String createdDate) {
        List<Course> course = courseRepository.getCourseByUpdatedDate(createdDate);
        course.stream().forEach(create -> create.setIsActive(Boolean.FALSE));
        courseRepository.saveAll(course);
    }

    //This function updates the 'isActive' column to false by giving the Updated date (deleteCoursesByUpdatedDate)
    public void deleteCoursesByUpdatedDate(String updatedDate) {
        List<Course> course = courseRepository.getCourseByUpdatedDate(updatedDate);
        course.stream().forEach(update -> update.setIsActive(Boolean.FALSE));
        courseRepository.saveAll(course);
    }

    // Create a new course record (createCourse)
    public void createCourse(String name) {
        Course course = new Course();
        course.setName(name);
        course.setCreatedDate(new Date());
        course.setUpdatedDate(new Date());
        course.setIsActive(Boolean.TRUE);
        courseRepository.save(course);
    }

    //update Course (whole row) [updateCourse]
    public String updateCourse(Integer id, String name, Boolean isActive, String userCreatedDate, String userUpdatedDate) {
        try {
            Course course = courseRepository.getCourseById(id);
            course.setName(name);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date createdDate = formatter.parse(userCreatedDate);
            Date updatedDate = formatter.parse(userUpdatedDate);
            course.setCreatedDate(createdDate);
            course.setUpdatedDate(updatedDate);
            course.setIsActive(isActive);
            courseRepository.save(course);
            return "The Course ID:" + id + " has been successfully updated :)";
        } catch (Exception e) {
            return "An error occurred, record is not updated. Please try again.";
        }
    }
}
/**/

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


//    public List<Course> getCourseByStudentName(String studentName) {
//        Course course = courseRepository.get
//                schoolRepository.getSchoolByName(studentName); // get school by school name
//        Integer schoolId = school.getId(); // getting the ID from school model and saving it into schoolId
//        List<Student> studentList = studentRepository.getStudentsBySchoolId(schoolId);
//        return studentList; // will return to whomever is calling the list which is the controller
//    }


