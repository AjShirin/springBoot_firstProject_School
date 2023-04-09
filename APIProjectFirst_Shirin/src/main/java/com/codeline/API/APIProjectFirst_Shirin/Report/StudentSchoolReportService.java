package com.codeline.API.APIProjectFirst_Shirin.Report;

import com.codeline.API.APIProjectFirst_Shirin.DTO.StudentReportDTO;
import com.codeline.API.APIProjectFirst_Shirin.Models.Student;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.SchoolRepository;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.StudentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentSchoolReportService {
    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    public static final String pathToReports = "C:\\Users\\user020\\IdeaProjects\\APIProjectFirst_Shirin\\APIProjectFirst_Shirin\\reports";


    public String generateStudentReport() throws FileNotFoundException, JRException {
        List<Student> studentList = studentRepository.getAllStudent();
        List<StudentReportDTO> StudentDTOList = new ArrayList<>();
        for (Student studentListVariable : studentList) {
            String schoolName = studentListVariable.getSchool().getName();

            String studentName = studentListVariable.getName();
            String studentRollNumber = studentListVariable.getRollNumber();
            StudentReportDTO studentDTO = new StudentReportDTO(schoolName, studentName, studentRollNumber);
            StudentDTOList.add(studentDTO);
        }

        File file = new File("C:\\Users\\user020\\IdeaProjects\\APIProjectFirst_Shirin\\APIProjectFirst_Shirin\\src\\main\\resources\\StudentReportFirst.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(StudentDTOList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Shirin");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\StudentReportFirst.pdf");
        return "Report generated : " + pathToReports + "\\StudentReportFirst.pdf";
    }
}