package xyz.calebwarner.fizzbuzz.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.calebwarner.fizzbuzz.service.FizzBuzzService;

import java.util.List;

@RestController
@RequestMapping("/api/fizzbuzz")
public class FizzBuzzController {

    private final FizzBuzzService fizzBuzzService;

    FizzBuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @GetMapping
    public List<String> getFizzBuzz() {
        return fizzBuzzService.getFizzBuzz(100);
    }

}
