package com.codeline.API.APIProjectFirst_Shirin.Controllers;


import com.codeline.API.APIProjectFirst_Shirin.Services.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping(value = "/report")

public class ReportController {
    @Autowired
    ReportService reportService;

    @RequestMapping(value = "/schoolReport", method = RequestMethod.GET)
    public String generateSchoolsReport() throws JRException, FileNotFoundException {
        return reportService.generateReport();
    }

    // Question 1
      @RequestMapping(method = RequestMethod.GET, value = "/studentAndTheirSchoolReport")
    public String generateStudentWithSchoolNameReport()  {
        try {
            return reportService.generateStudentWithSchoolNameReport();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Exception("Error").getMessage();

        }
    }

    // Question 2
    @RequestMapping(method = RequestMethod.GET, value = "/courseNameWithTheirMarksReport")
    public String generateCourseWithMarkReport() {
        try {
            return reportService.generateCourseWithMarkReport();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Exception("Error").getMessage();
        }
    }

    // Question 3
    @RequestMapping(method = RequestMethod.GET, value = "/courseNameWithAverageMarkReport")
    public String generateCourseNameWithAverageMarkReport() {
        try {
            return reportService.generateCourseNameWithAverageMarkReport();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Exception("Error").getMessage();
        }
    }

    // Question 4
    @RequestMapping(method = RequestMethod.GET, value = "/topPreformingStudentInEachSchoolReport")
    public String generateTopPerformingStudentInEachSchoolReport() {
        try {
            return reportService.generateTopPerformingStudentInEachSchool();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Exception("Error").getMessage();
        }
    }
    // Question 5
    @RequestMapping(method = RequestMethod.GET, value = "/OverallStudentPerformanceReport")
    public String generateOverAllStudentPerformance() {
        try {
            return reportService.generateOverallStudentPerformance();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Exception("Error").getMessage();
        }
    }
    // Question 6
    @RequestMapping(method = RequestMethod.GET, value = "/TotalNumberOfEachStudentReport")
    public String generateTotalNumberOfStudentsInEachSchool() {
        try {
            return reportService.generateTotalNumberOfStudentsInEachSchool();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Exception("Error").getMessage();
        }
    }




}
