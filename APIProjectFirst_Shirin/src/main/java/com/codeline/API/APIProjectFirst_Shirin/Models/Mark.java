package com.codeline.API.APIProjectFirst_Shirin.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mark {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer obtainMark;
    String grade;

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
