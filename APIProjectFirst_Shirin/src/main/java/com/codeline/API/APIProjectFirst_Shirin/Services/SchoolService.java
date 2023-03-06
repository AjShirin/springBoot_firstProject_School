package com.codeline.API.APIProjectFirst_Shirin.Services;

import com.codeline.API.APIProjectFirst_Shirin.Models.School;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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

    //function that gets all the school
    public List<School> getAllSchools() {
        return schoolRepository.getAllSchools();
    }

    public School getSchoolById(Integer id) {
        School school = schoolRepository.getSchoolById(id); // getting the id from the user
        return school; //creating an empty school and returning it.
    }


    public List<School> getAllActiveSchools() {
        return schoolRepository.getAllActiveSchools();
    }

    public List<School> getAllUnActiveSchools() {
        return schoolRepository.getAllUnActiveSchools();
    }

    public List<School> getSchoolLatestRow() {
        return schoolRepository.getSchoolLatestRow();
    }

    public List<School> getSchoolLatestUpdated() {
        return schoolRepository.getSchoolLatestUpdated();
    }

    // getSchoolCreatedAfterDate

    public School getSchoolByName(String school_name) {
        School schoolName = schoolRepository.getSchoolByName(school_name); // getting the school_name from the user
        return schoolName; //creating an empty school and returning it.
    }

    // getSchoolByCreatedDate

    //getSchoolByUpdatedDate

    // getSchoolByNumberOfStudents
    public void deleteSchoolById(Integer id) {
        School school = schoolRepository.getSchoolById(id);
//        School SchoolToDelete = schoolRepository.findById(Id);
        school.setIsActive(Boolean.FALSE);
        schoolRepository.save(school);
    }

    public void deleteAllSchool() {
        schoolRepository.deleteAllSchool();
    }

    //deleteAllSchoolsCreatedAfterDate

        public void deleteBySchoolName(String name) {
        School school=schoolRepository.getSchoolByName(name);
//      School SchoolToDelete = schoolRepository.findById(Id);
        school.setIsActive(Boolean.FALSE);
        schoolRepository.save(school);
    }

    //deleteSchoolsByCreatedDate
    //deleteSchoolsByUpdatedDate

    public void createSchool(String name) {
        School school = new School();
        school.setName(name);
        school.setCreatedDate(new Date());
        school.setUpdatedDate(new Date());
        school.setIsActive(Boolean.TRUE);
        schoolRepository.save(school);
    }

    //updateSchool

/////

//    public List<School> getSchoolCreatedAfterDate(){
//        return schoolRepository.getSchoolCreatedAfterDate();
//    }

    public void setCreatedDateByUserInput(String date, Integer id) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        School school = schoolRepository.getSchoolById(id); // the repository return the whole school object from the database.
        school.setCreatedDate(convertedDateFromStringToDateFormat);
        schoolRepository.save(school);
    }
}