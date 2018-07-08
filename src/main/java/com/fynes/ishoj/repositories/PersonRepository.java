package com.fynes.ishoj.repositories;

import com.fynes.ishoj.models.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository {

    Flux<Person> findAll();

    Mono<Person> findOne(int id);
}
