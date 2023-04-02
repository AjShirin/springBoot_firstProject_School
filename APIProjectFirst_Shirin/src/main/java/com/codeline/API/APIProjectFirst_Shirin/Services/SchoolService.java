package com.codeline.API.APIProjectFirst_Shirin.Services;

import com.codeline.API.APIProjectFirst_Shirin.Models.School;
import com.codeline.API.APIProjectFirst_Shirin.Models.Student;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.SchoolRepository;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service // this is where everything is going to be done related to the object such as function and many more
// here is where the business logic is done
// To give controller whatever it needs
public class SchoolService {

    @Autowired // create instance, and then it can be used in all the program
    SchoolRepository schoolRepository;
    @Autowired
    private StudentRepository studentRepository;

   //function that gets the school by id (getSchoolById)
    public School getSchoolById(Integer id) {
        School school = schoolRepository.getSchoolById(id); // getting the id from the user
        return school; //creating an empty school and returning it.
    }

    //function that gets all the school (getAllSchools)
    public List<School> getAllSchools() {
        return schoolRepository.getAllSchools();
    }

    // function that gets all the active schools (getAllActiveSchools)
    public List<School> getAllActiveSchools() {
        return schoolRepository.getAllActiveSchools();
    }

    // function that gets all the not active schools (getAllUnActiveSchools)
    public List<School> getAllUnActiveSchools() {
        return schoolRepository.getAllUnActiveSchools();
    }

    // function that gets the Latest row of the school (getSchoolLatestRow)
    public List<School> getSchoolLatestRow() {
        return schoolRepository.getSchoolLatestRow();
    }

    // function that gets the latest update for school (getSchoolLatestUpdated)
    public List<School> getSchoolLatestUpdated() {
        return schoolRepository.getSchoolLatestUpdated();
    }

    //function that checks if there is a date created bigger than the given date (getSchoolCreatedAfterDate)
    public List<School> getSchoolCreatedAfterDate(String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(createdDate);
        List<School> schools = schoolRepository.getSchoolCreatedAfterDate(convertedDateFromStringToDateFormat);
        return schools;
    }

   // function that gets the school by the name (getSchoolByName)
    public School getSchoolByName(String school_name) {
        School schoolName = schoolRepository.getSchoolByName(school_name); // getting the school_name from the user
        return schoolName; //creating an empty school and returning it.
    }

    // Function where it gets all the School Created by the given Date (getSchoolsByCreatedDate)
    public List<School> getSchoolByCreatedDate (String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(createdDate);
        List<School> schools = schoolRepository.getSchoolByCreatedDate(convertedDateFromStringToDateFormat);
        return schools;
    }

    // Function that gets all school create by the given updated date (getSchoolByUpdatedDate)
    public List<School> getSchoolByUpdatedDate(String UpdatedDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(UpdatedDate);
        List<School> schoolUpdatedDateVariable = schoolRepository.getSchoolByUpdatedDate(convertedDateFromStringToDateFormat);
        return schoolUpdatedDateVariable;
    }

    // Function that school by the User input for the Number of students (getSchoolByNumberOfStudents)
    public School getSchoolByNumberOfStudent(Integer numberOfStudent){
        List<Integer> typesOfSchoolIdsInStudent = studentRepository.getDistinctSchoolIdsFromStudent();
        Integer schoolIdThatUserWants = 0; // store the number of student the user wants
        for (Integer idOfSchool: typesOfSchoolIdsInStudent) { // for each loop to go through each school
            Integer count = studentRepository.getCountOfStudentsBySchoolId(idOfSchool);
            if(numberOfStudent == count) {
                schoolIdThatUserWants = idOfSchool; // store the id of the school that the user is looking for
                break;
            }
        }
        School schoolThatUserWasLookingFor = schoolRepository.getSchoolById(schoolIdThatUserWants);
        return schoolThatUserWasLookingFor;
    }

    // This function updates the 'isActive' column to false by the school ID (deleteSchoolById)
    public void deleteSchoolById(Integer id) {
        School school = schoolRepository.getSchoolById(id);
//        School SchoolToDelete = schoolRepository.findById(Id);
        school.setIsActive(Boolean.FALSE);
        schoolRepository.save(school);
    }

    // This function updates all the school 'isActive' column to false (deleteAllSchool)
    public void deleteAllSchool() {
        schoolRepository.deleteAllSchool();
    }

     // This function updates the 'isActive' column to false by giving the school name (deleteBySchoolName)
    public void deleteBySchoolName(String name) {
        School school = schoolRepository.getSchoolByName(name);
//      School SchoolToDelete = schoolRepository.findById(Id);
        school.setIsActive(Boolean.FALSE);
        schoolRepository.save(school);
    }

    //This function updates the 'isActive' column to false by giving the Created date (deleteSchoolsByCreatedDate)
//    public void deleteSchoolsByCreatedDate(String createdDate) {
//        List<School> schools = schoolRepository.getSchoolsByCreatedDate(createdDate);
//        schools.stream().forEach(create -> create.setIsActive(Boolean.FALSE));
//        schoolRepository.saveAll(schools);
//    }

    //This function updates the 'isActive' column to false by giving the Updated date (deleteSchoolsByUpdatedDate)
//    public void deleteSchoolsByUpdatedDate(String updatedDate) {
//        List<School> school = schoolRepository.getSchoolByUpdatedDate(updatedDate);
//        school.stream().forEach(update -> update.setIsActive(Boolean.FALSE));
//        schoolRepository.saveAll(school);
//    }

    // Create a new school record (createSchool)
    public void createSchool(String name) {
        School school = new School();
        school.setName(name);
        school.setCreatedDate(new Date());
        school.setUpdatedDate(new Date());
        school.setIsActive(Boolean.TRUE);
        schoolRepository.save(school);
    }

    //update School (whole row) [updateSchool]
    public void updateSchool(Integer id, String name, Boolean isActive) {
        School school = schoolRepository.getSchoolById(id);
        school.setName(name);
        school.setCreatedDate(new Date());
        school.setUpdatedDate(new Date());
        school.setIsActive(isActive);
        schoolRepository.save(school);
    }

/////

    public void setCreatedDateByUserInput(String date, Integer id) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        School school = schoolRepository.getSchoolById(id); // the repository return the whole school object from the database.
        school.setCreatedDate(convertedDateFromStringToDateFormat);
        schoolRepository.save(school);
    }
}