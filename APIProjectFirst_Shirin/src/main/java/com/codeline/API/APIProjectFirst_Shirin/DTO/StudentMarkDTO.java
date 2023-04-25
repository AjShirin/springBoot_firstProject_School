package com.codeline.API.APIProjectFirst_Shirin.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class StudentMarkDTO {
    Integer studentId;
    String studentRollNumber;
    String studentName;
    Integer averageMark;

    public StudentMarkDTO(Integer studentId, String studentRollNumber, String studentName, Integer averageMark) {
        this.studentId = studentId;
        this.studentRollNumber = studentRollNumber;
        this.studentName = studentName;
        this.averageMark = averageMark;
    }
}
