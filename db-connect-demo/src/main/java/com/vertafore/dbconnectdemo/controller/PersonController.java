package com.vertafore.dbconnectdemo.controller;

import com.vertafore.dbconnectdemo.data.PersonRepository;
import com.vertafore.dbconnectdemo.model.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PersonController {

    final PersonRepository personRepository;

    @PostMapping(value = "/addPerson")
    public void addPerson(@RequestBody Person person) {
        log.info("Got person: {}", person);
        personRepository.save(person);
    }

    @GetMapping(value = "/getPerson")
    public Person getPerson(@RequestParam long id) {
        Optional<Person> person = personRepository.findById(id);
        return person.orElse(null);
    }

    @GetMapping(value = "/getAll")
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @PostMapping(value = "/deletePerson")
    public void updatePerson(@RequestParam long id) {
        personRepository.deleteById(id);
    }
}
