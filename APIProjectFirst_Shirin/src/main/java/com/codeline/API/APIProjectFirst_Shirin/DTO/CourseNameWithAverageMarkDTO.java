package com.codeline.API.APIProjectFirst_Shirin.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CourseNameWithAverageMarkDTO {
     String courseName;
     Integer averageMark;

   //Constructor is similar to a class, it creates the instance of the class.
    //  its name is the same as the class name, and it has no return type.
    public CourseNameWithAverageMarkDTO(String courseName, Integer averageMark) {
        this.courseName = courseName;
        this.averageMark = averageMark;
    }
}
