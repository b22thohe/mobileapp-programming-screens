package com.example.screens;

import java.io.Serializable;

@SuppressWarnings("WeakerAccess")
public class RecyclerViewItems implements Serializable {
    private String[] dataSet;

    public RecyclerViewItems (String name, int age, String career, String rank, String status) {
        this.dataSet = new String[] {name, String.valueOf(age), career, rank, status};
    }
    // Getters for all member variables
    public String[] getDataset() {
        return dataSet;
    }
}
