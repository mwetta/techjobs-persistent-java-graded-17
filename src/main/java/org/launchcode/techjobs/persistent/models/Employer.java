package org.launchcode.techjobs.persistent.models;
// 2.2.1a Add string field for location with validation that ensures it is not empty and has a reasonable length;
// 2.2.1b add public accessor methods to employers
// 2.2.2 Make sure the class has the @Entity annotation, as well as the no-arg constructor required for Hibernate to create an object


// 3.1.1 Add a private property jobs of type List<Jobs> and initialize to an empty ArrayList
/* 3.1.2 Use the @OneToMany and @JoinColumn annotations on the jobs list in Employer to declare the relationship
    between data tables. Recall this annotation needs a name parameter - what value should it be?*/
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {
    @NotNull
    @Size(min=0, max=50)
    private String location;
    @OneToMany
    @JoinColumn(name = "employer_id")
    private final List<Job> jobs = new ArrayList<>();

    public Employer(){
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }
}
