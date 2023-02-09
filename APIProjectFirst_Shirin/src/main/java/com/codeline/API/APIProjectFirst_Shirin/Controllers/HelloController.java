package com.codeline.API.APIProjectFirst_Shirin.Controllers;

import com.codeline.API.APIProjectFirst_Shirin.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// doing this tag to create a Restfull API
@RestController
public class HelloController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public void addStudent() {
        studentService.addStudent();
    }

    // Ask the server to get something/ like Select
    // @GetMapping(name = "hello")
    // Creating a function that returns a string hello
    // public String helloPeople() {
    //  return "Hello";
    // }
    //@GetMapping(value = "deleteById") // inside the bracket is the endpoint
    //  public void


}
