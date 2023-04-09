package com.codeline.API.APIProjectFirst_Shirin.Report;

import com.codeline.API.APIProjectFirst_Shirin.DTO.MarkReportDTO;
import com.codeline.API.APIProjectFirst_Shirin.DTO.StudentReportDTO;
import com.codeline.API.APIProjectFirst_Shirin.Models.Mark;
import com.codeline.API.APIProjectFirst_Shirin.Models.Student;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.CourseRepository;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.MarkRepository;
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
public class CourseMarkReportService {
    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    MarkRepository markRepository;

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    public static final String pathToReports = "C:\\Users\\user020\\IdeaProjects\\APIProjectFirst_Shirin\\APIProjectFirst_Shirin\\reports";


    public String generateMarkReport() throws FileNotFoundException, JRException {
        List<Mark> markList = markRepository.getAllMarks();
        List<MarkReportDTO> MarkDTOList = new ArrayList<>();
        for (Mark markListVariable : markList) {
            String courseName = markListVariable.getCourse().getName();

            Integer obtainMarks = markListVariable.getObtainMark();
            String studentGrade = markListVariable.getGrade();
            MarkReportDTO markDTO = new MarkReportDTO(courseName, obtainMarks, studentGrade);
            MarkDTOList.add(markDTO);
        }

        File file = new File("C:\\Users\\user020\\IdeaProjects\\APIProjectFirst_Shirin\\APIProjectFirst_Shirin\\src\\main\\resources\\MarkReportTwo.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(MarkDTOList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Shirin");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\MarkReport.pdf");
        return "Report generated : " + pathToReports + "\\MarkReport.pdf";
    }
}

