package com.codeline.API.APIProjectFirst_Shirin.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class MarkReportDTO {

    public MarkReportDTO(String courseName, Integer obtainMarks, String studentGrade) {
        this.courseName = courseName;
        this.obtainMarks = obtainMarks;
        this.studentGrade = studentGrade;
    }

    String courseName;
    Integer obtainMarks;
    String studentGrade;

}
