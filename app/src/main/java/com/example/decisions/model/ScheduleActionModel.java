package com.example.decisions.model;

public class ScheduleActionModel extends ImageModel {

    private int doubleArrowRightImage;
    private int resourceImageCompleted;

    public ScheduleActionModel(String name, int resourceImage) {
        super(name, resourceImage);
    }

    public ScheduleActionModel(String name, int resourceImage, int doubleArrowRightImage, int resourceImageCompleted) {
        super(name, resourceImage);
        this.doubleArrowRightImage = doubleArrowRightImage;
        this.resourceImageCompleted = resourceImageCompleted;
    }

    public int getDoubleArrowRightImage() {
        return doubleArrowRightImage;
    }

    public void setDoubleArrowRightImage(int doubleArrowRightImage) {
        this.doubleArrowRightImage = doubleArrowRightImage;
    }

    public int getResourceImageCompleted() {
        return resourceImageCompleted;
    }

    public void setResourceImageCompleted(int resourceImageCompleted) {
        this.resourceImageCompleted = resourceImageCompleted;
    }
}
