package com.codeline.API.APIProjectFirst_Shirin.Controllers;

import com.codeline.API.APIProjectFirst_Shirin.Models.Mark;
import com.codeline.API.APIProjectFirst_Shirin.Services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    //function that returns all student
    public List<Mark> getAllMarks() { // This will take from the browser and then return in the browser
        List<Mark> mark = markService.getAllMarks(); // changing the list to the function because instead of we
        //initialize empty list and then insert data we directly inserted a data.
        return mark;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET) // "mark/getById" is a prefix
    public Mark getMarkById(@RequestParam Integer markId) { //Request Parameter gets the parameter you want
        // Mark mark = new Mark(); // creating an empty school
        //Mark mark = markService.getMarkById(markId); // so the school will return school = schoolService.getSchoolById(id)
        Mark mark = markService.getMarkById(markId);
        return mark;
    }

    @RequestMapping(value = "/getAllMarkByIsActive")
    public List<Mark> getAllActiveMark() {
        List<Mark> activeMarkList = markService.getAllActiveMark();
        return activeMarkList;
    }

    @RequestMapping(value = "/getAllMarkByIsUnActive")
    public List<Mark> getAllUnActiveMark() {
        List<Mark> notActiveMarkList = markService.getAllUnActiveMark();
        return notActiveMarkList;
    }
}
