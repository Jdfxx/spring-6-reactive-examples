package pl.filiphagno.spring6reactiveexamples.repository;

import pl.filiphagno.spring6reactiveexamples.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository {
    Mono<Person> getById(Integer id);
    Flux<Person> getAll();
}
