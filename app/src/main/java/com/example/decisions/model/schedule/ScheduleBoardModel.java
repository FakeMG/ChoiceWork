package com.example.decisions.model.schedule;

import com.example.decisions.model.ImageModel;

import java.io.Serializable;

public class ScheduleBoardModel extends ImageModel implements Serializable {

    public ScheduleBoardModel(String name, int resourceImage) {
        super(name, resourceImage);
    }
}
