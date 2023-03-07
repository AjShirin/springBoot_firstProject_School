package com.codeline.API.APIProjectFirst_Shirin.Controllers;

import com.codeline.API.APIProjectFirst_Shirin.Models.Course;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.CourseRepository;
import com.codeline.API.APIProjectFirst_Shirin.Services.CourseService;
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



//    @RequestMapping(value = "/getByCourseName", method = RequestMethod.GET)
//    public Course getByCourseName(@RequestParam String course_name) {
//        Course courseName = courseRepository.getCourseByName(course_name);
//        return courseName;
//    }




}