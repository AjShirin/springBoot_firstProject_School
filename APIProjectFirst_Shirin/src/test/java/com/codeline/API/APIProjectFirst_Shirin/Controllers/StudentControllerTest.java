package com.codeline.API.APIProjectFirst_Shirin.Controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentControllerTest {
    @Autowired
    StudentController studentController;

    @Test
    void getStudentById() throws Exception{
        String studentName = studentController.getStudentById(11).getName();
        assertEquals("Shirin",studentName);
    }

    @Test
    void getStudentByIdTwo() throws Exception{
        String studentName = studentController.getStudentById(12).getName();
        assertEquals("Ruqia",studentName);
    }
    @Test
    void getStudentByIdThree() throws Exception{
        String studentName = studentController.getStudentById(13).getName();
        assertEquals("Marwa",studentName);
    }
    @Test
    void getStudentByIdFour() throws Exception{
        String studentName = studentController.getStudentById(14).getName();
        assertEquals("Farah",studentName);
    }
}