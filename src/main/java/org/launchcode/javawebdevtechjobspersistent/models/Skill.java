package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

//Entity annotation
@Entity
public class Skill extends AbstractEntity {

    @Size(max = 200, message = "Maximum description is 200 characters")
    private String description;

    public Skill(String description) {
        this.description = description;
    }
    public Skill(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}