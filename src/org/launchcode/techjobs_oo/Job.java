package org.launchcode.techjobs_oo;

import java.util.*;

public class Job {

    private int id;
    private static int nextId = 1;
    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString(){
        String returnString;
        //if only Id exists, print "This job does not exist"
        if(positionType == null && name == null && employer == null && location == null && coreCompetency == null){
            returnString = "OOPS! This job does not seem to exist.";

        }else {
            HashMap<String, String> fields = new HashMap<>();
            fields.put("ID", String.valueOf(id));
            fields.put("Name", name);
            fields.put("Employer", employer.toString());
            fields.put("Location", getLocation().toString());
            fields.put("Position Type", positionType.toString());
            fields.put("Core Competency", coreCompetency.toString());

            // if field is empty, replace with "Data not available"
            for(Map.Entry<String,String> entry : fields.entrySet()){
                if(entry.getValue().equals("")){
                    fields.replace(entry.getKey(), entry.getValue(), "Data not available");
                }

            }

            returnString = " \n" + "ID: " + id + "\nName: " + fields.get("Name") + "\nEmployer: " + fields.get("Employer") + "\nLocation: " + fields.get("Location") + "\nPosition Type: " + fields.get("Position Type") + "\nCore Competency: " + fields.get("Core Competency") + "\n ";
        }

        return returnString;

    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    //Getters and setters never used
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Employer getEmployer() { return employer; }

    public void setEmployer(Employer employer) { this.employer = employer; }

    public Location getLocation() { return location; }

    public void setLocation(Location location) { this.location = location; }

    public PositionType getPositionType() { return positionType; }

    public void setPositionType(PositionType positionType) { this.positionType = positionType; }

    public CoreCompetency getCoreCompetency() { return coreCompetency; }

    public void setCoreCompetency(CoreCompetency coreCompetency) { this.coreCompetency = coreCompetency; }

    public int getId() { return id; }
}
