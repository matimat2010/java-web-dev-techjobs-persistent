package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Job extends AbstractEntity{


    @ManyToOne
    private Employer employer;
    private String skills;

    public Job() {
    }

    public Job(Employer employer, String skills) {
        super();
        this.employer = employer;
        this.skills = skills;
    }

    // Getters and setters.
//
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
