package com.codeline.API.APIProjectFirst_Shirin.Controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SchoolControllerTest {
    @Autowired
    SchoolController schoolController;

    @Test
    void getSchoolById() throws Exception{
        String schoolName = schoolController.getSchoolById(1).getName();
        assertEquals("marwa",schoolName);
    }
    @Test
    void getSchoolByIdTwo() throws Exception{
        String schoolName = schoolController.getSchoolById(2).getName();
        assertEquals("santop",schoolName);
    }
    @Test
    void getSchoolByIdThree() throws Exception{
        String schoolName = schoolController.getSchoolById(3).getName();
        assertEquals("kitkat",schoolName);
    }
    @Test
    void getSchoolByIdFour() throws Exception{
        String schoolName = schoolController.getSchoolById(4).getName();
        assertEquals("chips",schoolName);
    }
}