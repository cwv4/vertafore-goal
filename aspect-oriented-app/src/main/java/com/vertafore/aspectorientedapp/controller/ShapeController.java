package com.vertafore.aspectorientedapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ShapeController {

    @GetMapping("/shape")
    public String getShape() {
        return "Shape";
    }

}
