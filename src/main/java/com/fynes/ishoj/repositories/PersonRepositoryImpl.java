package com.fynes.ishoj.repositories;

import com.fynes.ishoj.models.Person;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository{

    private List<Person>  dummyData;

    public PersonRepositoryImpl(){
        // Dummy data for now
        dummyData = new ArrayList<>();
        dummyData.add(new Person(1,"jim"));
        dummyData.add(new Person(2,"dave"));
        dummyData.add(new Person(3,"frank"));
    }

    @Override
    public Flux<Person> findAll() {
        return Flux.fromIterable(dummyData);
    }

    @Override
    public Mono<Person> findOne(int id) {

        Flux<Person> flux = Flux.fromIterable(dummyData).filter(p -> p.getId() == id);

        return flux.next();
    }
}
