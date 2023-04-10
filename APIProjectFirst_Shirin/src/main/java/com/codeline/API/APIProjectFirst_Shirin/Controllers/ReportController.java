package com.codeline.API.APIProjectFirst_Shirin.Controllers;


import com.codeline.API.APIProjectFirst_Shirin.Services.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping(value = "report")

public class ReportController {
    @Autowired
    ReportService reportService;

    @RequestMapping(value = "schoolReport", method = RequestMethod.GET)
    public String generateSchoolsReport() throws JRException, FileNotFoundException {
        return reportService.generateReport();
    }

    @RequestMapping(value = "studentAndTheirSchoolReport", method = RequestMethod.GET)
    public void generateStudentWithSchoolNameReport() throws JRException, FileNotFoundException {
        reportService.generateStudentWithSchoolNameReport();
    }

    @RequestMapping(value = "courseNameWithTheirMarksReport", method = RequestMethod.GET)
    public void generateCourseWithMarkReport() throws JRException, FileNotFoundException {
    reportService.generateCourseWithMarkReport();
    }
}
