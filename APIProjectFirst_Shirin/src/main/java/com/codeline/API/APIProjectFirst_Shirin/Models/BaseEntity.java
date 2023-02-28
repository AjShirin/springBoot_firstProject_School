package com.codeline.API.APIProjectFirst_Shirin.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.MappedSuperclass;
import java.util.Date;
@Setter
@Getter
@Data // handles constructor
// This is the parent class , and will do inheritance so that we don't repeat the same attribute. but if the generation
// type is different we cannot use it. so to make the program consistent we will use Identity.

// The annotation is to map with the SQL
@MappedSuperclass
public class BaseEntity {
    @CreatedDate
    Date createdDate;
    @UpdateTimestamp
    Date UpdatedDate;
    Boolean isActive;
}
