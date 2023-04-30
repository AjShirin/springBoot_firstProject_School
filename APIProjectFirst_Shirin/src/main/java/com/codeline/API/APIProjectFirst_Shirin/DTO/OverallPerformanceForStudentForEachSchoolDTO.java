package com.codeline.API.APIProjectFirst_Shirin.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class OverallPerformanceForStudentForEachSchoolDTO {
    String schoolName;
    Integer averageOfAllStudentsMarks;

    public OverallPerformanceForStudentForEachSchoolDTO(String schoolName, Integer averageOfAllStudentsMarks) {
        this.schoolName = schoolName;
        this.averageOfAllStudentsMarks = averageOfAllStudentsMarks;
    }
}
