package com.codeline.API.APIProjectFirst_Shirin.Services;

import com.codeline.API.APIProjectFirst_Shirin.Models.Mark;
import com.codeline.API.APIProjectFirst_Shirin.Models.Student;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.MarkRepository;
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
public class MarkService {

    @Autowired // create instance, and then it can be used in all the program //like object chaining
    MarkRepository markRepository;

    // Function that gets the make by the ID (getById)
    public Mark getMarkById(Integer id) {
        Mark mark = markRepository.getMarkById(id); // getting the id from the user
        return mark; //creating an empty course and returning it.
    }

    // Function that gets all the school (getAll)
    public List<Mark> getAllMarks() {
        return markRepository.getAllMarks();
    }

    // Function That gets all Marks that are active (getAllActive)
    public List<Mark> getAllActiveMark(){
        return markRepository.getAllActiveMark();
    }

    // Function that gets all the marks that are not active (getAllInActive)
    public List<Mark> getAllUnActiveMark(){
        return markRepository.getAllUnActiveMark();
    }

    // Function that gets all the Latest Row of the mark table (getLatestRow)
    public List<Mark> getLatestRow() {
        return markRepository.getLatestRow();
    }

    // function that gets the latest update for Mark (getLatestUpdated)
    public List<Mark> getLatestUpdated() {
        return markRepository.getLatestUpdated();
    }

    //function that checks if there is a date created bigger than the given date (getMarksCreatedAfterDate)
    public List<Mark> getMarksCreatedAfterDate(String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(createdDate);
        List<Mark> Marks = markRepository.getMarksCreatedAfterDate(convertedDateFromStringToDateFormat);
        return Marks;
    }
    //Function that gets all grade by the user input (getAllByGrade)
    public List<Mark> getAllByGrade(String grade){
        List<Mark> mark = markRepository.getAllByGrade(grade);
        return mark;
    }

    //Function that gets the obtain mark which is bigger than the given (getByObtainedMarksMoreThan)
    public List<Mark> getByObtainedMarksMoreThan(Integer obtainMark){
        List<Mark> markToObtain = markRepository.getByObtainedMarksMoreThan(obtainMark);
        return markToObtain;
    }

    //Function that gets the obtain mark which is less than the given (getByObtainedMarksLessThan)
    public List<Mark> getByObtainedMarksLessThan(Integer obtainMark){
        List<Mark> markToObtain = markRepository.getByObtainedMarksLessThan(obtainMark);
        return markToObtain;
    }
    // Function where it gets all the Marks Updated by the given Date (getMarksByUpdatedDate)
    public List<Mark> getMarksByUpdatedDate(String UpdatedDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(UpdatedDate);
        List<Mark> marksUpdatedDate = markRepository.getMarksByUpdatedDate(convertedDateFromStringToDateFormat);
        return marksUpdatedDate;
    }
    // Function where it gets all the Marks by the Course ID  (getMarksByCourseId)
    public List<Mark> getMarksByCourseId(Integer courseId){
        List<Mark> markListForCourseId = markRepository.getMarksByCourseId(courseId);
        return markListForCourseId;
    }

    // This function updates the 'isActive' column to false by the Mark ID (deleteById)
    public void deleteById(Integer id) {
        Mark mark = markRepository.getMarkById(id);
        mark.setIsActive(Boolean.FALSE);
        markRepository.save(mark);
    }
    // This function updates all the Marks 'isActive' column to false (deleteAll)
    public void deleteAllMarks() {
        markRepository.deleteAllMarks();
    }
    //This function updates the 'isActive' column to false by giving the Created date (deleteAllMarksCreatedAfterDate)
    public void deleteAllMarksCreatedAfterDate(String createdDate) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(createdDate);
        List<Mark> marksCreatedDate = markRepository.getMarksCreatedAfterDate(convertedDateFromStringToDateFormat);
        marksCreatedDate.stream().forEach(create -> create.setIsActive(Boolean.FALSE)); //Java stream operation that iterates through all the Student objects
        // in the studentsCreatedDate list and sets their isActive property to false.
        //it creates a stream of Student objects from the studentsCreatedDate list, and for each Student object in the stream,
        // it executes the lambda expression create -> create.setIsActive(Boolean.FALSE)
        //The lambda expression sets the isActive property of the current Student object in the stream to false.
            markRepository.saveAll(marksCreatedDate);
    }









}