package com.codeline.API.APIProjectFirst_Shirin.Services;

import com.codeline.API.APIProjectFirst_Shirin.Models.Mark;
import com.codeline.API.APIProjectFirst_Shirin.Repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // this is where everything is going to be done related to the object such as function and many more
public class MarkService {

    @Autowired // create instance, and then it can be used in all the program
    MarkRepository markRepository;


    //function that gets all the school
    public List<Mark> getAllMarks() {
        return markRepository.getAllMarks();
    }
}