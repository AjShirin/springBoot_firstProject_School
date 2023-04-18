package com.codeline.API.APIProjectFirst_Shirin.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Data
public class StudentReportDTO {

    String schoolName;
    String studentName;
    String studentRollNumber;

    public StudentReportDTO(String schoolName, String studentName, String studentRollNumber) {
        this.schoolName = schoolName;
        this.studentName = studentName;
        this.studentRollNumber = studentRollNumber;
    }


}
