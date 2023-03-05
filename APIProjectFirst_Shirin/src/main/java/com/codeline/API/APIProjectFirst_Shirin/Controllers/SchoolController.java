package com.codeline.API.APIProjectFirst_Shirin.Controllers;

import com.codeline.API.APIProjectFirst_Shirin.Models.School;
import com.codeline.API.APIProjectFirst_Shirin.RequestObject.SchoolRequestForCreateDateUpdate;
import com.codeline.API.APIProjectFirst_Shirin.Services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

// since we put @RequestMapping for the class in the top , so there is no need to add it in @RequestMapping  for function
//ex:  @RequestMapping(value = "Customer")
//@RequestMapping(value = "/getIsActive", method = RequestMethod.GET)

@RestController
@RequestMapping(value = "school")
// Any request coming form browser that is related to school it will be mapped with this class
public class SchoolController {

    @Autowired // create instance, and then it can be used in all the program //like object chaining
    // if we remove the auto wire it will return null because there is no value
    // (if you don't want to use @Autowire you can do SchoolService schoolService = new SchoolService --> this is called injection dependency )
    // for school controller to work , school service should work since they are dependent on each other
    SchoolService schoolService;

    // general form of request handling and define the method should that can be get
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    //function that returns all school
    public List<School> getAllSchools() { // This will take from the browser and then return in the browser
        List<School> schools = schoolService.getAllSchools(); // changing the list to the function because instead of we
        //initialize empty list and then insert data we directly inserted a data.
        return schools;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET) // "school/getById" is a prefix
    public School getSchoolById(@RequestParam Integer schoolId) { //Request Parameter gets the parameter you want
        // School school = new School(); // creating an empty school
        //schoolService.getSchoolById(schoolId); // so the school will return school = schoolService.getSchoolById(id)
        School school = schoolService.getSchoolById(schoolId);
        return school;
    }

    @RequestMapping(value = "/getBySchoolName", method = RequestMethod.GET)
    public School getBySchoolName(@RequestParam String school_name) {
        School schoolName = schoolService.getSchoolByName(school_name);
        return schoolName;
    }

    @RequestMapping(value = "/getAllSchoolByIsActive")
    public List<School> getAllActiveSchools() {
        List<School> activeSchoolsList = schoolService.getAllActiveSchools();
        return activeSchoolsList;
    }

    @RequestMapping(value = "/getAllSchoolByIsUnActive")
    public List<School> getAllUnActiveSchools() {
        List<School> notActiveSchoolsList = schoolService.getAllUnActiveSchools();
        return notActiveSchoolsList;
    }

    @RequestMapping(value = "/getSchoolLatestRow")
    public List<School> getSchoolLatestRow() {
        List<School> schoolLatestRowList = schoolService.getSchoolLatestRow();
        return schoolLatestRowList;
    }
    @RequestMapping(value = "/getSchoolLatestUpdated")
    public List<School> getSchoolLatestUpdated() {
        List<School> schoolLatestUpdatedList = schoolService.getSchoolLatestUpdated();
        return schoolLatestUpdatedList;
    }

    @RequestMapping(value = "/deleteSchoolById")
    public void deleteSchoolById(Integer id) {
          schoolService.deleteSchoolById(id);
    }

    @RequestMapping(value = "/deleteAllSchool")
    public void deleteAllSchool(){
        schoolService.deleteAllSchool();
    }

//    @RequestMapping(value = "/getSchoolCreatedAfterDate", method = RequestMethod.GET)
//    public School getSchoolCreatedAfterDate(@RequestParam String createdDate) {
//        School createdAfterDate = schoolService.getSchoolCreatedAfterDate(createdDate);
//        return createdAfterDate;
//    }

    @RequestMapping(value = "/updateCreatedDateByUserInput")
    public void setCreatedDateByUserInput(@RequestBody SchoolRequestForCreateDateUpdate data) throws ParseException {
        schoolService.setCreatedDateByUserInput(data.getDate(), data.getId());
    }

//    @RequestMapping(value = "/getSchoolByCreatedDate")
//    public List<School> getSchoolByCreatedDate() {
//        List<School> schoolByCreatedDateList = schoolService.getSchoolByCreatedDate();
//        return schoolByCreatedDateList;
//    }
}
