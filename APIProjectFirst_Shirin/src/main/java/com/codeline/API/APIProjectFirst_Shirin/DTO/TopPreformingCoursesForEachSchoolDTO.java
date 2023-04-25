package com.codeline.API.APIProjectFirst_Shirin.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TopPreformingCoursesForEachSchoolDTO {
    String schoolName;
    String courseName;

    public TopPreformingCoursesForEachSchoolDTO(String schoolName, String courseName) {
        this.schoolName = schoolName;
        this.courseName = courseName;
    }
}
