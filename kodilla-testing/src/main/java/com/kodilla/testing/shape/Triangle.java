package com.kodilla.testing.shape;

public class Triangle implements Shape{
    private String shapeName = "Triangle";
    private double field;

    public Triangle(int a, int h){
        field = a*h/2;
    }

    public String getShapeName(){
        return shapeName;
    }

    public double getField(){
        return field;
    }
}
