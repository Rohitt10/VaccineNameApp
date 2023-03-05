package com.example.vaccinenameapp;

public class Vaccine {
    String name;
    int image;
    Vaccine(String name,int image)
    {
        this.name=name;
        this.image=image;
    }
    public int getImage() {
        return image;
    }
    public String getName() {
        return name;
    }
}
