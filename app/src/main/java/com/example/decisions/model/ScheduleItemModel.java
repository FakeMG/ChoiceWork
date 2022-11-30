package com.example.decisions.model;

import java.io.Serializable;

public class ScheduleItemModel implements Serializable {

    private int resourceImage;

    public ScheduleItemModel(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }
}
