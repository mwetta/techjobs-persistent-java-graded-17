package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;

// 2.2.3 Add a field for a longer description of the skill, named description, with public accessor methods.
// 2.2.4 As with Employer, give this class the @Entity annotation and be sure it contains a no-arg constructor
@Entity
public class Skill extends AbstractEntity {
    @Size(min=0, max=500)
    private String description;

    public Skill() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
