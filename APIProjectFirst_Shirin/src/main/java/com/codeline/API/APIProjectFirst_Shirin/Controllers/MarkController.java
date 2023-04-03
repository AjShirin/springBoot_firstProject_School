package com.codeline.API.APIProjectFirst_Shirin.Controllers;

import com.codeline.API.APIProjectFirst_Shirin.Models.Mark;
import com.codeline.API.APIProjectFirst_Shirin.Models.School;
import com.codeline.API.APIProjectFirst_Shirin.Models.Student;
import com.codeline.API.APIProjectFirst_Shirin.Services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;
// since we put @RequestMapping for the class in the top , so there is no need to add it in @RequestMapping  for function
//ex:  @RequestMapping(value = "Customer")
//@RequestMapping(value = "/getIsActive", method = RequestMethod.GET)

@RestController
@RequestMapping(value = "mark")
// Any request coming form browser that is related to mark it will be mapped with this class
public class MarkController {

    @Autowired // create instance, and then it can be used in all the program //like object chaining
    // if we remove the auto wire it will return null because there is no value
    // (if you don't want to use @Autowire you can do SchoolService schoolService = new SchoolService --> this is called injection dependency )
    // for school controller to work , school service should work since they are dependent on each other

    MarkService markService;

    // Function that gets the make by the ID (getById)
    @RequestMapping(value = "/getById", method = RequestMethod.GET) // "mark/getById" is a prefix
    public Mark getMarkById(@RequestParam Integer markId) { //Request Parameter gets the parameter you want
        // Mark mark = new Mark(); // creating an empty school
        //Mark mark = markService.getMarkById(markId); // so the school will return school = schoolService.getSchoolById(id)
        Mark mark = markService.getMarkById(markId);
        return mark;
    }

    // Function that gets all the school (getAll)
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    //function that returns all student
    public List<Mark> getAllMarks() { // This will take from the browser and then return in the browser
        List<Mark> mark = markService.getAllMarks(); // changing the list to the function because instead of we
        //initialize empty list and then insert data we directly inserted a data.
        return mark;
    }

    // Function That gets all Marks that are active (getAllActive)
    @RequestMapping(value = "/getAllMarkByIsActive")
    public List<Mark> getAllActiveMark() {
        List<Mark> activeMarkList = markService.getAllActiveMark();
        return activeMarkList;
    }

    // Function that gets all the marks that are not active (getAllInActive)
    @RequestMapping(value = "/getAllMarkByIsUnActive")
    public List<Mark> getAllUnActiveMark() {
        List<Mark> notActiveMarkList = markService.getAllUnActiveMark();
        return notActiveMarkList;
    }
    // Calls the function that gets the latest row of mark (getLatestRow)
    @RequestMapping(value = "/getLatestRow")
    public List<Mark> getLatestRow() {
        List<Mark> markLatestRowList = markService.getLatestRow();
        return markLatestRowList;
    }
    // function that gets the latest update for Mark (getLatestUpdated)
    @RequestMapping(value = "/getLatestUpdated", method = RequestMethod.GET)
    public List<Mark> getLatestUpdated(){
        List<Mark> markLatestUpdate = markService.getLatestUpdated();
        return markLatestUpdate;
    }

    //function that checks if there is a date created bigger than the given date (getMarksCreatedAfterDate)
    @RequestMapping(value = "/getMarksCreatedAfterDate", method = RequestMethod.GET)
    public List<Mark> getMarksCreatedAfterDate(@RequestParam String createdDate) throws ParseException {
        List<Mark> createdAfterDate = markService.getMarksCreatedAfterDate(createdDate);
        return createdAfterDate;
    }
    //Function that gets all grade by the user input (getAllByGrade)
    @RequestMapping(value = "/getAllByGrade", method = RequestMethod.GET)
    public List<Mark> getAllByGrade(String grade) {
        List<Mark> markList = markService.getAllByGrade(grade);
        return markList;
    }
    //Function that gets the obtain mark which is bigger than the given (getByObtainedMarksMoreThan)
    @RequestMapping(value = "/getByObtainedMarksMoreThan", method = RequestMethod.GET)
    public List<Mark> getByObtainedMarksMoreThan(Integer obtainMark) {
        List<Mark> markToObtain = markService.getByObtainedMarksMoreThan(obtainMark);
        return markToObtain;
    }
    //Function that gets the obtain mark which is bigger than the given (getByObtainedMarksLessThan)
    @RequestMapping(value = "/getByObtainedMarksLessThan", method = RequestMethod.GET)
    public List<Mark> getByObtainedMarksLessThan(Integer obtainMark) {
        List<Mark> markToObtain = markService.getByObtainedMarksLessThan(obtainMark);
        return markToObtain;
    }

    // Calls the function where it gets all the Marks Updated by the given Date (getMarksByUpdatedDate)
    @RequestMapping(value = "/getMarksByUpdatedDate", method = RequestMethod.GET)
    public List<Mark> getMarksByUpdatedDate(String UpdatedDate) throws ParseException {
        List<Mark> getMarkByUpdatedDateVariable = markService.getMarksByUpdatedDate(UpdatedDate);
        return getMarkByUpdatedDateVariable;
    }
    @RequestMapping(value = "/getMarksByCourseId", method = RequestMethod.GET)
    public List<Mark> getMarksByCourseId(@RequestParam Integer courseId) {
        return markService.getMarksByCourseId(courseId);
    }







}
