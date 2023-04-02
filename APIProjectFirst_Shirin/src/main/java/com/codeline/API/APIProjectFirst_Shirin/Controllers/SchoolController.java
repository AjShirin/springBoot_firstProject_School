package com.codeline.API.APIProjectFirst_Shirin.Controllers;

import com.codeline.API.APIProjectFirst_Shirin.Models.School;
import com.codeline.API.APIProjectFirst_Shirin.Models.Student;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.SchoolRepository;
import com.codeline.API.APIProjectFirst_Shirin.RequestObject.SchoolRequestForCreateDateUpdate;
import com.codeline.API.APIProjectFirst_Shirin.Services.SchoolService;
import com.codeline.API.APIProjectFirst_Shirin.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @Autowired
    SlackClient slackClient;
    @Autowired
    private SchoolRepository schoolRepository;

   // get school by ID (getById)
    @RequestMapping(value = "/getById", method = RequestMethod.GET) // "school/getById" is a prefix
    public School getSchoolById(@RequestParam Integer schoolId) { //Request Parameter gets the parameter you want
        // School school = new School(); // creating an empty school
        //schoolService.getSchoolById(schoolId); // so the school will return school = schoolService.getSchoolById(id)
        School school = schoolService.getSchoolById(schoolId);
//        slackClient.sendMessage("The school Id is:" + school.getId()); //** open later
//        slackClient.sendMessage("The Name of the School is :" + school.getName()); //** open later
        return school;
    }

   // get all school (getAll)
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    //function that returns all school
    public List<School> getAllSchools() { // This will take from the browser and then return in the browser
        List<School> schools = schoolService.getAllSchools(); // changing the list to the function because instead of we
        //initialize empty list and then insert data we directly inserted a data.
        return schools;
    }

    // get all the active schools (getAllActiveSchools)
    @RequestMapping(value = "/getAllSchoolByIsActive")
    public List<School> getAllActiveSchools() {
        List<School> activeSchoolsList = schoolService.getAllActiveSchools();
        return activeSchoolsList;
    }
    // get all the not active schools (getAllSchoolByIsUnActive)
    @RequestMapping(value = "/getAllSchoolByIsUnActive")
    public List<School> getAllUnActiveSchools() {
        List<School> notActiveSchoolsList = schoolService.getAllUnActiveSchools();
        return notActiveSchoolsList;
    }

    // gets the Latest row of the school (getSchoolLatestRow)
    @RequestMapping(value = "/getSchoolLatestRow")
    public List<School> getSchoolLatestRow() {
        List<School> schoolLatestRowList = schoolService.getSchoolLatestRow();
        return schoolLatestRowList;
    }

    //gets the latest update for school (getSchoolLatestUpdated)
    @RequestMapping(value = "/getSchoolLatestUpdated")
    public List<School> getSchoolLatestUpdated() {
        List<School> schoolLatestUpdatedList = schoolService.getSchoolLatestUpdated();
        return schoolLatestUpdatedList;
    }
    //function that checks if there is a date created bigger than the given date (getSchoolCreatedAfterDate)
    @RequestMapping(value = "/getSchoolCreatedAfterDate", method = RequestMethod.GET)
    public List<School> getSchoolCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<School> createdAfterDate = schoolService.getSchoolCreatedAfterDate(createdDate);
        return createdAfterDate;
    }
    // function that gets the school by the name (getSchoolByName)
    @RequestMapping(value = "/getBySchoolName", method = RequestMethod.GET)
    public School getBySchoolName(@RequestParam String school_name) {
        School schoolName = schoolService.getSchoolByName(school_name);
        return schoolName;
    }

    // Function where it gets all the School Created by the given Date (getSchoolByCreatedDate)
    @RequestMapping(value = "/getSchoolByCreatedDate", method = RequestMethod.GET)
    public List<School> getSchoolByCreatedDate(String createdDate) throws ParseException {
        List<School> getSchoolByCreatedDateVariable = schoolService.getSchoolByCreatedDate(createdDate);
        return getSchoolByCreatedDateVariable;
    }

    // Function where it gets all the School Updated by the given Date (getSchoolByUpdatedDate)
    @RequestMapping(value = "/getSchoolByUpdatedDate", method = RequestMethod.GET)
    public List<School> getSchoolByUpdatedDate(String UpdatedDate) throws ParseException {
        List<School> getSchoolByUpdatedDateVariable = schoolService.getSchoolByUpdatedDate(UpdatedDate);
        return getSchoolByUpdatedDateVariable;
    }

    // Function that school by the User input for the Number of students (getSchoolByNumberOfStudents)
    @RequestMapping(value = "/getSchoolByNumberOfStudent", method = RequestMethod.POST)
    public School getSchoolByNumberOfStudent(@RequestParam Integer numberOfStudent) {
        return schoolService.getSchoolByNumberOfStudent(numberOfStudent);

    }

    // This function updates the 'isActive' column to false by the school ID (deleteSchoolById)
    @RequestMapping(value = "/deleteSchoolById")
    public void deleteSchoolById(Integer id) {
        schoolService.deleteSchoolById(id);
    }

    // This function updates all the school 'isActive' column to false (deleteAllSchool)
    @RequestMapping(value = "/deleteAllSchool")
    public void deleteAllSchool() {
        schoolService.deleteAllSchool();
    }

    // This function updates the 'isActive' column to false by giving the school name (deleteBySchoolName)
    @RequestMapping(value = "/deleteBySchoolName")
    public void deleteBySchoolName(@RequestParam String name) {
        schoolService.deleteBySchoolName(name);
    }

    //This function updates the 'isActive' column to false by giving the Created date (deleteSchoolsByCreatedDate)
    @RequestMapping(value = "/deleteSchoolsByCreatedDate", method = RequestMethod.POST)
    public ResponseEntity<String> deleteSchoolsByCreatedDate(@RequestParam String createdDate) { // ResponseEntity<String> represents an HTTP,
        // response with a body of type String, that returns response from a controller,and allows us to customize the HTTP response status.
        try {
            String response = schoolService.deleteSchoolsByCreatedDate(createdDate);
            return ResponseEntity.ok(response);
        } catch (ParseException e) {
            return ResponseEntity.badRequest().body("Invalid date format :( Try again");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting school :(");
        }
    }



    //This function updates the 'isActive' column to false by giving the Updated date (deleteSchoolsByUpdatedDate)
//    @RequestMapping(value = "/deleteSchoolsByUpdatedDate ", method = RequestMethod.POST)
//    public void deleteSchoolsByUpdatedDate(@RequestParam String updatedDate) {
//        schoolService.deleteSchoolsByUpdatedDate(updatedDate);
//    }

    // Create a new school record (createSchool)
    @RequestMapping(value = "/createSchool")
    public void createSchool(String name) {
        schoolService.createSchool(name);
    }

    //update School (whole row) [updateSchool]
    @RequestMapping(value = "/updateSchool")
    public void updateSchool(@RequestParam Integer id, String name, Boolean isActive) {
        schoolService.updateSchool(id, name, isActive);
    }
    ////////

    @RequestMapping(value = "/updateCreatedDateByUserInput")
    public void setCreatedDateByUserInput(@RequestBody SchoolRequestForCreateDateUpdate data) throws ParseException {
        schoolService.setCreatedDateByUserInput(data.getDate(), data.getId());
    }
}
