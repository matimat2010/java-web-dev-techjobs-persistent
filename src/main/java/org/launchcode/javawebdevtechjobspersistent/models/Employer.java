package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



//Entity annotation
@Entity
public class Employer extends AbstractEntity {

    //Validation / Required
    @NotBlank(message = "Location is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String location;

    //Constructor
    public Employer(String location) {
        this.location = location;
    }

    //Empty Constructor required for Hibernate to create an object
    public Employer() {}

    //Getter and Setter for "Location" field
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

}
