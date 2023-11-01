package org.launchcode.techjobs.persistent.models;
// 2.2.1a Add string field for location with validation that ensures it is not empty and has a reasonable length;
// 2.2.1b add public accessor methods to employers
// 2.2.2 Make sure the class has the @Entity annotation, as well as the no-arg constructor required for Hibernate to create an object

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
public class Employer extends AbstractEntity {
    @NotNull
    @Size(min=0, max=50)
    private String location;

    public Employer(){
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
