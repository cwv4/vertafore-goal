package xyz.calebwarner.fizzbuzz.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FizzBuzzService {

    public List<String> getFizzBuzz(int count) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            result.add(getFizzBuzzElement(i));
        }

        return result;
    }

    private String getFizzBuzzElement(int number) {
        if (number % 15 == 0) {
            return "FizzBuzz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        }

        return String.valueOf(number);
    }

}
