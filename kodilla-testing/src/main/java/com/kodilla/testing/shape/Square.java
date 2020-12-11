package com.kodilla.testing.shape;

public class Square implements Shape{
    private String shapeName = "Square";
    private double field;

    public Square(int a) {
        field = a*a;
    }

    public String getShapeName(){
        return shapeName;
    }

    public double getField(){
        return field;
    }
}
