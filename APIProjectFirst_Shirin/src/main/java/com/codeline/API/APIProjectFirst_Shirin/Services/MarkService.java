package com.codeline.API.APIProjectFirst_Shirin.Services;

import com.codeline.API.APIProjectFirst_Shirin.Models.Mark;
import com.codeline.API.APIProjectFirst_Shirin.Models.Student;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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




}