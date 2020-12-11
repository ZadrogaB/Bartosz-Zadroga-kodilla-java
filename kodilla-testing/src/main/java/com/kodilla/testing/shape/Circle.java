package com.kodilla.testing.shape;

public class Circle implements Shape{
    private String shapeName = "Circle";
    private double field;

    public Circle(int r){
        field = 3.14*r*r;
    }

    public String getShapeName(){
        return shapeName;
    }

    public double getField(){
        return field;
    }
}
