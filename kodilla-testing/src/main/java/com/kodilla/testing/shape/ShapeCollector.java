package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List <Shape> shapeList = new ArrayList<>();

    public void addFigure(Shape shape){
        shapeList.add(shape);
    }

    public void removeFigure(Shape shape){
        shapeList.remove(shape);
    }

    public Shape getFigure(int n){
        return shapeList.get(n);
    }

    public String showFigures(){
        StringBuilder stringBuilder = new StringBuilder();
        int numberOfLoops = 1;

        for (Shape shape : shapeList){
            if(numberOfLoops<shapeList.size()) {
                stringBuilder.append(shape.getShapeName());
                stringBuilder.append(", ");
            } else {
                stringBuilder.append(shape.getShapeName());
            }
            numberOfLoops++;
        }
        return  stringBuilder.toString();
    }

    public List<Shape> getShapeList() {
        return shapeList;
    }
}
