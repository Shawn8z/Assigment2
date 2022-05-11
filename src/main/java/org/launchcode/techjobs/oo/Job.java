package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;
    private int emptySlots = 0;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        this.id = this.nextId;
        this.nextId++;
    }

    public Job(String aName, Employer dEmployer, Location dLocation, PositionType dPositionType,
               CoreCompetency dCoreCompetency) {
        this();
        this.name = aName;
        this.employer = dEmployer;
        this.location = dLocation;
        this.positionType = dPositionType;
        this.coreCompetency = dCoreCompetency;
    }



    @Override
    public String toString() {
        String result = "\n";
        String aName, aEmployer, aLocation, aPositionType, aCoreCompetency;

        // use helperfunction emptyStrChecker to fill in all the variables based on values in the fields
        aName = this.emptyStrChecker(this.name);
        aEmployer = this.emptyStrChecker(this.employer.toString());
        aLocation = this.emptyStrChecker(this.location.toString());
        aPositionType = this.emptyStrChecker(this.positionType.toString());
        aCoreCompetency = this.emptyStrChecker(this.coreCompetency.toString());

        // if all 5 fields are "" return  'OOPS! This job does not seem to exist.'
        if (emptySlots == 5) {
            return "OOPS! This job does not seem to exist.";
        }

        // put together the result string
        result += "ID: " + this.id + "\n" +
                "Name: " + aName + "\n" +
                "Employer: " + aEmployer + "\n" +
                "Location: " + aLocation + "\n" +
                "Position Type: " + aPositionType + "\n" +
                "Core Competency: " + aCoreCompetency + "\n" +
                "\n";

        return result;
    }


    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return this.id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }
    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }
    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }
    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    private String emptyStrChecker(String str) {
        String result;
        // if input is "" change result to 'Data not available'
        // also increment emptySlots by 1;

        // else return input as result

        if (str.equals("")) {
            result = "Data not available";
            this.emptySlots += 1;
        } else {
            result = str;
        }
        return result;
    }
}
