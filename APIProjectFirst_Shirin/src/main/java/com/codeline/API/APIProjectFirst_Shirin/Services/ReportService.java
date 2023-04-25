package com.codeline.API.APIProjectFirst_Shirin.Services;

import com.codeline.API.APIProjectFirst_Shirin.DTO.CourseNameWithAverageMarkDTO;
import com.codeline.API.APIProjectFirst_Shirin.DTO.MarkReportDTO;
import com.codeline.API.APIProjectFirst_Shirin.DTO.StudentReportDTO;
import com.codeline.API.APIProjectFirst_Shirin.DTO.TopPreformingStudentDTO;
import com.codeline.API.APIProjectFirst_Shirin.Models.Course;
import com.codeline.API.APIProjectFirst_Shirin.Models.Mark;
import com.codeline.API.APIProjectFirst_Shirin.Models.School;
import com.codeline.API.APIProjectFirst_Shirin.Models.Student;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.CourseRepository;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.MarkRepository;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.SchoolRepository;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.StudentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private MarkRepository markRepository;
    public static final String pathToReports = "C:\\Users\\user020\\IdeaProjects\\APIProjectFirst_Shirin\\APIProjectFirst_Shirin\\reports";

    public String generateReport() throws FileNotFoundException, JRException {
        List<School> schoolList = schoolRepository.getAllSchools(); // gives all schools

        File file = ResourceUtils.getFile("classpath:School_Report.jrxml"); // everything is java is a function or a clas that is why we create an object
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath()); // compiling the report accord to the format using the jasper
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(schoolList); // give the schoolList that created before
        Map<String, Object> paramters = new HashMap<>(); // create a hashmap to put your watermarks
        paramters.put("CreatedBy", "Shirin"); // putting key and value just to say who created the file
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource); // calling this function from jasper to fill the report by giving the parameters
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\schools.pdf"); // export the report in pdf format
        return "Report generated : " + pathToReports + "\\schools.pdf"; // saving the file to the path given
    }

    // Question 1
    public String generateStudentWithSchoolNameReport() throws JRException {
        List<Student> studentList = studentRepository.getAllStudent();
        List<StudentReportDTO> StudentDTOList = new ArrayList<>();
        for (Student studentListVariable : studentList) {
            String schoolName = studentListVariable.getSchool().getName();

            String studentName = studentListVariable.getName();
            String studentRollNumber = studentListVariable.getRollNumber();
            StudentReportDTO studentDTO = new StudentReportDTO(schoolName, studentName, studentRollNumber);
            StudentDTOList.add(studentDTO);
        }

        File file = new File("C:\\Users\\user020\\IdeaProjects\\APIProjectFirst_Shirin\\APIProjectFirst_Shirin\\src\\main\\resources\\SchoolStudentName.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath()); // compile the code and made report
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(StudentDTOList);// create data
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Shirin");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource); // print the report and the data source
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\StudentsAndTheirSchoolReportQuestion1.pdf"); // export the file to pdf
        return "Report generated : " + pathToReports + "\\StudentsAndTheirSchoolReportQuestion1.pdf";
    }

    // Question 2
    public String generateCourseWithMarkReport() throws JRException {
        List<Mark> markList = markRepository.getAllMarks();
        List<MarkReportDTO> MarkDTOList = new ArrayList<>();
        for (Mark markListVariable : markList) {
            String courseName = markListVariable.getCourse().getName();

            Integer obtainMarks = markListVariable.getObtainMark();
            String studentGrade = markListVariable.getGrade();
            MarkReportDTO markDTO = new MarkReportDTO(courseName, obtainMarks, studentGrade);
            MarkDTOList.add(markDTO);
        }

        File file = new File("C:\\Users\\user020\\IdeaProjects\\APIProjectFirst_Shirin\\APIProjectFirst_Shirin\\src\\main\\resources\\CourseNameAndMarkForEveryStudent.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(MarkDTOList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Shirin");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\CourseAndTheirMarkReportQuestion2.pdf");
        return "Report generated : " + pathToReports + "\\CourseAndTheirMarkReportQuestion2.pdf";
    }

    // Question 3
    public String generateCourseNameWithAverageMarkReport() throws JRException {
        List<Course> courseList = courseRepository.findAll();
        List<CourseNameWithAverageMarkDTO> courseNameWithAverageMarkDTOSList = new ArrayList<>();
        for (Course course : courseList) {
            String courseName = course.getName();
            Integer averageMark = markRepository.getAverageMarksByCourseName(courseName);
            CourseNameWithAverageMarkDTO courseNameWithAverageMarkDTOVariable = new CourseNameWithAverageMarkDTO(courseName, averageMark);
            courseNameWithAverageMarkDTOSList.add(courseNameWithAverageMarkDTOVariable);
        }
        File file = new File("C:\\Users\\user020\\IdeaProjects\\APIProjectFirst_Shirin\\APIProjectFirst_Shirin\\src\\main\\resources\\AverageMarkOfEachCourse.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(courseNameWithAverageMarkDTOSList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Shirin");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\CourseNameWithAverageMarkQuestion3.pdf");
        return "Report generated : " + pathToReports + "\\CourseNameWithAverageMarkQuestion3.pdf";
    }

    // Question 4
    public String generateTopPerformingStudentInEachSchool() throws Exception {
        List<School> schoolList = schoolRepository.getAllSchools();
        List<TopPreformingStudentDTO> topPreformingStudentDTOSList = new ArrayList<>();

        for (School school : schoolList) {
            List<Student> studentList = studentRepository.getStudentsBySchoolId(school.getId());
            Integer highestMark = 0;
            Student studentWithHighestMark = new Student();
            for (Student student : studentList) {
                Integer studentId = student.getId();
                Integer studentTotalMark = markRepository.getSumOfMarksByStudentId(studentId);
                if (studentTotalMark != null && studentTotalMark > highestMark) {
                    highestMark = studentTotalMark;
                    studentWithHighestMark = student;
                }
            }
            topPreformingStudentDTOSList.add(new TopPreformingStudentDTO(studentWithHighestMark.getName(), school.getName())); // DTO removes the need for hash map
        }

        File file = new File("C:\\Users\\user020\\IdeaProjects\\APIProjectFirst_Shirin\\APIProjectFirst_Shirin\\src\\main\\resources\\ToPreformingStudent.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(topPreformingStudentDTOSList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Shirin");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\TopPreformingStudentGroupByMarksQuestion4.pdf");
        return "Report generated : " + pathToReports + "\\TopPreformingStudentGroupByMarksQuestion4.pdf";
    }
}
