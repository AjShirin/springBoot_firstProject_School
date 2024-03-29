package com.codeline.API.APIProjectFirst_Shirin.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TopPreformingStudentDTO {
    String studentName;
    String schoolName;

    public TopPreformingStudentDTO(String studentName, String schoolName) {
        this.studentName = studentName;
        this.schoolName = schoolName;
    }
}
