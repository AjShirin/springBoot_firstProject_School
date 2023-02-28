package com.codeline.API.APIProjectFirst_Shirin.Services;

import com.codeline.API.APIProjectFirst_Shirin.Models.School;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public School getSchoolByName(String school_name) {
        School schoolName = schoolRepository.getSchoolByName(school_name); // getting the school_name from the user
        return schoolName; //creating an empty school and returning it.
    }

    public List<School> getAllActiveSchools(){
        return schoolRepository.getAllActiveSchools();
    }

    public List<School> getAllUnActiveSchools(){
        return schoolRepository.getAllUnActiveSchools();
    }

    public void setCreatedDateByUserInput(String date, Integer id) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        School school = schoolRepository.getSchoolById(id); // the repository return the whole school object from the database.
        school.setCreatedDate(convertedDateFromStringToDateFormat);
        schoolRepository.save(school);
    }
}
