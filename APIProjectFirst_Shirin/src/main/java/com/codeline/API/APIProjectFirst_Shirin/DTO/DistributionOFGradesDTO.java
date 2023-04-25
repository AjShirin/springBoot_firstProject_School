package com.codeline.API.APIProjectFirst_Shirin.DTO;

import com.codeline.API.APIProjectFirst_Shirin.Models.Course;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class DistributionOFGradesDTO {
    String courseName;
    String grade;
    Integer totalMarks;

    public DistributionOFGradesDTO(String courseName, String grade, Integer totalMarks) {
        this.courseName = courseName;
        this.grade = grade;
        this.totalMarks = totalMarks;
    }
}
