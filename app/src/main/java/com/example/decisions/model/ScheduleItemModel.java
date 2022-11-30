package com.example.decisions.model;

import java.io.Serializable;

public class ScheduleItemModel implements Serializable {

    private String name;
    private int resourceImage;

    public ScheduleItemModel(String name, int resourceImage) {
        this.name = name;
        this.resourceImage = resourceImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }
}
