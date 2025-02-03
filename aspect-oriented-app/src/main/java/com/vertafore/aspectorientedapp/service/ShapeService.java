package com.vertafore.aspectorientedapp.service;

import org.springframework.stereotype.Service;

@Service
public class ShapeService {

    public int getSquareArea(int length) {
        return length * length;
    }

    public double getCircleArea(int radius) {
        return Math.PI * radius * radius;
    }
}
