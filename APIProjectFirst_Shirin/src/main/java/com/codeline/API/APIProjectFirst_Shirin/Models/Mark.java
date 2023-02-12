package com.codeline.API.APIProjectFirst_Shirin.Models;

import javax.persistence.*;

@Entity
public class Mark {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer obtainMark;
    String grade;

    @ManyToOne // many mark to one course
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    Course course;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getObtainMark() {
        return obtainMark;
    }

    public void setObtainMark(Integer obtainMark) {
        this.obtainMark = obtainMark;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
