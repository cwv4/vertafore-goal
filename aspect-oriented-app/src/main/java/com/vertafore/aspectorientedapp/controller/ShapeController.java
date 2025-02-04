package com.vertafore.aspectorientedapp.controller;

import com.vertafore.aspectorientedapp.service.ShapeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;

@RestController
@RequestMapping("/api")
public class ShapeController {

    ShapeService service;

    public ShapeController(ShapeService service) {
        this.service = service;
    }

    @GetMapping("/square/{length}")
    public String handleSquare(@PathVariable int length) {
        return "A square with length " + length + "m would have an area of: " + service.getSquareArea(length) + "m";
    }

    @GetMapping("/circle/{radius}")
    public String handleCircle(@PathVariable int radius) {
        DecimalFormat df = new DecimalFormat("#.##");
        return "A circle with radius " + radius + "m would have an area of: " + df.format(service.getCircleArea(radius)) + "m";
    }

    @GetMapping("/triangle/{name}")
    public String handleTriangle(@PathVariable String name) {
        return "Your triangle's string is: " + service.getTriangle(name);
    }

    @GetMapping("/hexagon/{name}")
    public String handleHexagon(@PathVariable String name) {
        return "Your hexagon's string is: " + service.getHexagon(name);
    }
}
