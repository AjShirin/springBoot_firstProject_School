package com.codeline.API.APIProjectFirst_Shirin.Controllers;

import com.codeline.API.APIProjectFirst_Shirin.Report.CourseMarkReportService;
import com.codeline.API.APIProjectFirst_Shirin.Report.StudentSchoolReportService;
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
    @Autowired
    StudentSchoolReportService studentSchoolReportService;

    @Autowired
    CourseMarkReportService courseMarkReportService;

    @RequestMapping(value = "schoolReport", method = RequestMethod.GET)
    public String generateSchoolsReport() throws JRException, FileNotFoundException {
        return reportService.generateReport();
    }

    @RequestMapping(value = "studentReport", method = RequestMethod.GET)
    public void generateStudentReport() throws JRException, FileNotFoundException {
        studentSchoolReportService.generateStudentReport();

    }

    @RequestMapping(value = "markReport", method = RequestMethod.GET)
    public void generateMarkReport() throws JRException, FileNotFoundException {
    courseMarkReportService.generateMarkReport();
    }
}
