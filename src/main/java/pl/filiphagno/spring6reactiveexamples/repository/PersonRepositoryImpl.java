package pl.filiphagno.spring6reactiveexamples.repository;

import pl.filiphagno.spring6reactiveexamples.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

public class PersonRepositoryImpl implements PersonRepository {

    Person mike = Person.builder()
            .id(1)
            .firstName("Mike")
            .lastName("Brown")
            .build();
    Person john = Person.builder()
            .id(2)
            .firstName("john")
            .lastName("Brown")
            .build();
    Person jay = Person.builder()
            .id(3)
            .firstName("Jay")
            .lastName("Brown")
            .build();
    Person filip = Person.builder()
            .id(4)
            .firstName("Filip")
            .lastName("Brown")
            .build();



    @Override
    public Mono<Person> getById(Integer id) {
        return findAll().filter(person -> Objects.equals(person.getId(), id)).next();    }

    @Override
    public Flux<Person> findAll() {
        return Flux.just(john, jay, filip, mike);
    }
}
