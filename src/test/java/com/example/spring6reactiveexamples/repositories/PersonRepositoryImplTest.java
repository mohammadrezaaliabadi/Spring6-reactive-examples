package com.example.spring6reactiveexamples.repositories;

import com.example.spring6reactiveexamples.domain.Person;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

class PersonRepositoryImplTest {
    PersonRepository personRepository = new PersonRepositoryImpl();

    @Test
    void testMonoByIdBlock() {
        Mono<Person> personMono = personRepository.getById(1);

        Person person = personMono.block();
        System.out.println(person.toString());
    }

    @Test
    void testGetByIdSubscriber(){
        Mono<Person> personMono = personRepository.getById(1);
        personMono.subscribe(System.out::println);

    }

    @Test
    void testMapOperation() {
        Mono<Person> personMono = personRepository.getById(1);
        personMono.map(Person::getFirstName)
                .subscribe(System.out::println);


    }
    @Test
    void findAll() {

    }
}