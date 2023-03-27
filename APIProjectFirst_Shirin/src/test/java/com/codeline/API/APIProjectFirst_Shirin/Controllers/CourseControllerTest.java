package com.codeline.API.APIProjectFirst_Shirin.Controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseControllerTest {
    @Autowired
    CourseController courseController;

    @Test
    void getCourseById() throws Exception{
        String CourseName = courseController.getCourseById(12).getName();
        assertEquals("Java",CourseName);
    }
    @Test
    void getCourseByIdTwo() throws Exception{
        String CourseName = courseController.getCourseById(13).getName();
        assertEquals("Python",CourseName);
    }
    @Test
    void getCourseByIdThree() throws Exception{
        String CourseName = courseController.getCourseById(14).getName();
        assertEquals("HTML",CourseName);
    }
    @Test
    void getCourseByIdFour() throws Exception{
        String CourseName = courseController.getCourseById(15).getName();
        assertEquals("CSS",CourseName);
    }
}