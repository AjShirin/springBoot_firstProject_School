package com.codeline.API.APIProjectFirst_Shirin.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TotalNumberOfStudentInEachSchoolDTO {
    String schoolName;
    Integer totalNumberOfStudents;

    public TotalNumberOfStudentInEachSchoolDTO(String schoolName, Integer totalNumberOfStudents) {
        this.schoolName = schoolName;
        this.totalNumberOfStudents = totalNumberOfStudents;
    }
}
