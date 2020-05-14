package org.launchcode.techjobs_oo;

import java.util.Objects;

public abstract class JobField {


    private int id;
    private static int nextId = 1;
    private String value;

    // Shared constructors
    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }
    // Shared toString Method
    @Override
    public String toString() {
        return value;
    }

    //Shared equals and hashcode,
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof JobField)) return false;
        JobField jobField = (JobField) o;
        return getId() == jobField.getId();
    }

    //Getters and Setters never used?
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

