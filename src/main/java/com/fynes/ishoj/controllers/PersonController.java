package com.fynes.ishoj.controllers;

import com.fynes.ishoj.models.Person;
import com.fynes.ishoj.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {

    PersonRepository personRepository;

    public PersonController(@Autowired PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @GetMapping("/person")
    Flux<Person> list() {
        return this.personRepository.findAll();
    }

    @GetMapping("/person/{id}")
    Mono<Person> findById(@PathVariable int id) {
        return this.personRepository.findOne(id);
    }
}
