package com.codeline.API.APIProjectFirst_Shirin.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class HigherThanACertainThresholdStudentDTO {
    String courseName;
    Integer countOfStudents;

    public HigherThanACertainThresholdStudentDTO(String courseName, Integer countOfStudents) {
        this.courseName = courseName;
        this.countOfStudents = countOfStudents;
    }
}
