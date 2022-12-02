package com.example.decisions.model;

import java.io.Serializable;

public abstract class ImageModel implements Serializable {
    private String name;
    private int resourceImage;

    public ImageModel(String name, int resourceImage) {
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
