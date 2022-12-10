package com.example.decisions.model;

public class ChooseImageModel extends ImageModel {
    private boolean isSelected;

    public ChooseImageModel(String name, int resourceImage) {
        super(name, resourceImage);
        isSelected = false;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
