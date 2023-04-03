package com.codeline.API.APIProjectFirst_Shirin.Services;

import com.codeline.API.APIProjectFirst_Shirin.Models.School;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.SchoolRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private SchoolRepository schoolRepository;
    public static final String pathToReports = "C:\\Users\\user020\\Downloads\\reports";
    public String generateReport() throws FileNotFoundException, JRException {
        List<School> schoolList = schoolRepository.getAllSchools(); // gives all schools

        File file = ResourceUtils.getFile("classpath:School_Report.jrxml"); // everything is java is a function or a clas that is why we create an object
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath()); // compiling the report accord to the format using the jasper
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(schoolList); // give the schoolList that created before
        Map<String, Object> paramters = new HashMap<>(); // create a hashmap to put your watermarks
        paramters.put("CreatedBy", "Shirin"); // putting key and value just to say who created the file
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource); // calling this function from jasper to fill the report by giving the parameters
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\schools.pdf"); // export the report in pdf format
        return "Report generated : " + pathToReports+"\\schools.pdf"; // saving the file to the path given
    }

}
