package com.codeline.API.APIProjectFirst_Shirin.Controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MarkControllerTest {
    @Autowired
    MarkController markController;

    @Test
    void getById() throws Exception{
        String markGrade = markController.getMarkById(3).getGrade();
        assertEquals("A",markGrade);
    }
    @Test
    void getByIdTwo() throws Exception{
        String markGrade = markController.getMarkById(4).getGrade();
        assertEquals("D",markGrade);
    }

    @Test
    void getByIdThree() throws Exception{
        String markGrade = markController.getMarkById(5).getGrade();
        assertEquals("B",markGrade);
    }
    @Test
    void getByIdFour() throws Exception{
        String markGrade = markController.getMarkById(6).getGrade();
        assertEquals("c",markGrade);
    }


}