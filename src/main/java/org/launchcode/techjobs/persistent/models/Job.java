package org.launchcode.techjobs.persistent.models;

// 3.2.1 Update to extend AbstractEntity and remove redundant fields
// 3.2.2 Replace the type of the field employer to be of type Employer, and refactor affected constructor, getter, and setter
// 3.2.3 Add the @ManyToOne annotation on the field employer

// TODO 3.3 Uncomment test in TestTaskThree

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Job extends AbstractEntity {
    @ManyToOne
    private Employer employer;
    private String skills;

    public Job() {
    }

    // Initialize the id and value fields.
    public Job(Employer anEmployer, String someSkills) {
        super();
        this.employer = anEmployer;
        this.skills = someSkills;
    }

    // Getters and setters.
    
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

}
