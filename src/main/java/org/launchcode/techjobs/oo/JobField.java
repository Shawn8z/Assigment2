package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {

    private int id;
    private static int nextId = 1;
    private String value;

    public JobField() {
        this.id = nextId;
        nextId++;
    }

    public JobField(String aValue) {
        this();
        this.value = aValue;
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


    @Override
    public boolean equals(Object targetObj) {
        if (this == targetObj) {
            return true;
        }
        if (targetObj == null) {
            return false;
        }
        if (!(targetObj instanceof PositionType)) {
            return false;
        }
        PositionType position = (PositionType) targetObj;
        return this.getId() == position.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return this.value;
    }

}
