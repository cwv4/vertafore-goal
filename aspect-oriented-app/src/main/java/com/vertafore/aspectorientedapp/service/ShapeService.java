package com.vertafore.aspectorientedapp.service;

import com.vertafore.aspectorientedapp.model.Hexagon;
import com.vertafore.aspectorientedapp.model.Triangle;
import org.springframework.stereotype.Service;

@Service
public class ShapeService {

    private final Triangle triangle;
    private final Hexagon hexagon;

    public ShapeService(Triangle triangle, Hexagon hexagon) {
        this.triangle = triangle;
        this.hexagon = hexagon;
    }

    public int getSquareArea(int length) {
        return length * length;
    }

    public double getCircleArea(int radius) {
        return Math.PI * radius * radius;
    }

    public String getTriangle(String name) {
        triangle.setName(name);
        return triangle.toString();
    }

    public String getHexagon(String name) {
        hexagon.setName(name);
        return hexagon.toString();
    }
}
