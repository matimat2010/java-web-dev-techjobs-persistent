package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

//Entity annotation
@Entity
public class Skill extends AbstractEntity {

    @ManyToMany(mappedBy="skills")
    private List<Job> jobs = new ArrayList<>();

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