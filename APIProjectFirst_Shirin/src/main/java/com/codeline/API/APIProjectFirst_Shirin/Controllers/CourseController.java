package com.codeline.API.APIProjectFirst_Shirin.Controllers;

import com.codeline.API.APIProjectFirst_Shirin.Models.Course;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.CourseRepository;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.SchoolRepository;
import com.codeline.API.APIProjectFirst_Shirin.Services.CourseService;
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
@RequestMapping(value = "course")
// Any request coming form browser that is course to school it will be mapped with this class
public class CourseController {

    @Autowired // create instance, and then it can be used in all the program //like object chaining
    // if we remove the auto wire it will return null because there is no value

    // (if you don't want to use @Autowire you can do SchoolService schoolService = new SchoolService --> this is called injection dependency )
    // for school controller to work , school service should work since they are dependent on each other
    CourseService courseService;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private SchoolRepository schoolRepository;

    //function that gets all courses by id (getCourseById)
    @RequestMapping(value = "/getById", method = RequestMethod.GET) // "course/getById" is a prefix
    public Course getCourseById(@RequestParam Integer courseId) { //Request Parameter gets the parameter you want
        // Course course = new Course(); // creating an empty school
        //courseService.getCourseById(courseId); // so the school will return school = schoolService.getSchoolById(id)
        Course course = courseService.getCourseById(courseId);
        return course;
    }

    //function that gets all the course (getAllCourse)
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    //function that returns all student
    public List<Course> getAllCourse() { // This will take from the browser and then return in the browser
        List<Course> course = courseService.getAllCourse(); // changing the list to the function because instead of we
        //initialize empty list and then insert data we directly inserted a data.
        return course;
    }

    // function that gets all the active Course (getAllActiveCourse)
    @RequestMapping(value = "/getAllCourseByIsActive")
    public List<Course> getAllActiveCourse() {
        List<Course> activeCourseList = courseService.getAllActiveCourse();
        return activeCourseList;
    }

    // function that gets all the  not active Courses (getAllUnActiveCourse)
    @RequestMapping(value = "/getAllCourseByIsUnActive")
    public List<Course> getAllUnActiveCourse() {
        List<Course> notActiveCourseList = courseService.getAllUnActiveCourse();
        return notActiveCourseList;
    }

    // gets the Latest row of the Course (getCourseLatestRow)
    @RequestMapping(value = "/getCourseLatestRow")
    public List<Course> getCourseLatestRow() {
        List<Course> courseLatestRowList = courseService.getCourseLatestRow();
        return courseLatestRowList;
    }

    //gets the latest update for course (getCourseLatestUpdated)
    @RequestMapping(value = "/getCourseLatestUpdated")
    public List<Course> getCourseLatestUpdated() {
        List<Course> courseLatestUpdatedList = courseService.getCourseLatestUpdated();
        return courseLatestUpdatedList;
    }
    //function that checks if there is a date created bigger than the given date (getCourseCreatedAfterDate)
    @RequestMapping(value = "/getCourseCreatedAfterDate", method = RequestMethod.GET)
    public List<Course> getCourseCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<Course> createdAfterDate = courseService.getCourseCreatedAfterDate(createdDate);
        return createdAfterDate;
    }

    // function that gets the Course by the name (getByCourseName)
    @RequestMapping(value = "/getByCourseName", method = RequestMethod.GET)
    public List<Course> getByCourseName(@RequestParam String course_name) {
        List<Course> courseName = courseService.getCoursesByName(course_name);
        return courseName;
    }

    // Function where it gets all the Course Created by the given Date (getCourseByCreatedDate)
    @RequestMapping(value = "/getCourseByCreatedDate", method = RequestMethod.GET)
    public List<Course> getCourseByCreatedDate(String createdDate) throws ParseException {
        List<Course> getCourseByCreatedDateVariable = courseService.getCourseByCreatedDate(createdDate);
        return getCourseByCreatedDateVariable;
    }
    // Function where it gets all the Course Updated by the given Date (getCourseByUpdatedDate)
    @RequestMapping(value = "/getCourseByUpdatedDate", method = RequestMethod.GET)
    public List<Course> getCourseByUpdatedDateVariable(String UpdatedDate) throws ParseException {
        List<Course> getSchoolByUpdatedDateVariable = courseService.getCourseByUpdatedDate(UpdatedDate);
        return getSchoolByUpdatedDateVariable;
    }

    // Function that gets all courses from the student ID (getCourseByStudentId)
    @RequestMapping(value = "/getCourseByStudentId", method = RequestMethod.GET)
    public List<Course> getCourseByStudentId(@RequestParam Integer studentId) {
        List<Course> courseByStudentIdList = courseService.getCourseByStudentId(studentId);
       return courseByStudentIdList;
    }

    //Function that gets all courses that are active (getAllActiveCoursesForAStudent)
    @RequestMapping(value = "/getAllActiveCoursesForAStudent", method = RequestMethod.GET)
    public List<Course> getAllActiveCoursesForAStudent(Integer studentId) {
        List<Course> allActiveCoursesForAStudent = courseService.getAllActiveCoursesForAStudent(studentId);
        return allActiveCoursesForAStudent;
    }

    // get all the active course (getAllActiveCourses)
    @RequestMapping(value = "/getAllActiveCourses")
    public List<Course> getAllActiveCourses() {
        List<Course> activeCourseList = courseService.getAllActiveCourses();
        return activeCourseList;
    }

    // This function updates the 'isActive' column to false by the course ID (deleteById)
    @RequestMapping(value = "/deleteById")
    public void deleteById(Integer id) {
        courseService.deleteById(id);
    }

    // This function updates all the course 'isActive' column to false (deleteAll)
    @RequestMapping(value = "/deleteAll")
    public void deleteAll() {
        courseService.deleteAll();
    }

    // This function updates all courses that is greater than the given created date (deleteAllCoursesCreatedAfterDate)
    @RequestMapping(value = "/deleteAllCoursesCreatedAfterDate", method = RequestMethod.POST)
    public String deleteAllCoursesCreatedAfterDate(@RequestParam String createdDate)  {
        try {
            courseService.deleteAllCoursesCreatedAfterDate(createdDate);
        } catch (ParseException e) {
            return "Failed try again";
        }
        return "Deleted Successfully :)";
    }

    // This function updates the 'isActive' column to false by giving the course name (deleteByCourseName)
    @RequestMapping(value = "/deleteByCourseName")
    public void deleteByCourseName(@RequestParam String name) {
        courseService.deleteCoursesByName(name);
    }

    //This function updates the 'isActive' column to false by giving the Created date (deleteCoursesByCreatedDate)
    @RequestMapping(value = "/deleteCoursesByCreatedDate", method = RequestMethod.POST)
    public void deleteCoursesByCreatedDate(@RequestParam String createdDate) {
        courseService.deleteCoursesByCreatedDate(createdDate);
    }

    //This function updates the 'isActive' column to false by giving the Updated date (deleteCoursesByUpdatedDate)
    @RequestMapping(value = "/deleteCoursesByUpdatedDate ", method = RequestMethod.POST)
    public void deleteCoursesByUpdatedDate(@RequestParam String updatedDate) {
        courseService.deleteCoursesByUpdatedDate(updatedDate);
    }

    // Create a new course record (createCourse)
    @RequestMapping(value = "/createCourse")
    public void createCourse(String name) {
        courseService.createCourse(name);
    }
    // This function Updates a record for Course  with user Input (updateCourse)
    @RequestMapping(value = "/updateCourse", method = RequestMethod.PUT)
    public ResponseEntity<String> updateCourse(@RequestParam Integer id, String name, Boolean isActive, String userCreatedDate, String userUpdatedDate) {
        // ResponseEntity<String> represents an HTTP,
        // response with a body of type String, that returns response from a controller,and allows us to customize the HTTP response status.
        try {
            String responseMsg = courseService.updateCourse(id, name, isActive, userCreatedDate, userUpdatedDate);
            return ResponseEntity.ok().body(responseMsg);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred, Course is not updated. Please try again.");
        }
    }

}



//    @RequestMapping(value = "/getByCourseName", method = RequestMethod.GET)
//    public Course getByCourseName(@RequestParam String course_name) {
//        Course courseName = courseRepository.getCourseByName(course_name);
//        return courseName;
//    }


