package pl.filiphagno.spring6reactiveexamples.repository;

import org.junit.jupiter.api.Test;
import pl.filiphagno.spring6reactiveexamples.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

class PersonRepositoryImplTest {

    PersonRepository repo = new PersonRepositoryImpl();

    @Test
    void testMonoByIDBlock() {
        Mono<Person> personMono = repo.getById(1);
        Person person = personMono.block();
        assertNotNull(person);
        System.out.println(person);
    }

    @Test
    void testMonoByIDSubscribe() {
        Mono<Person> personMono = repo.getById(1);
        personMono.subscribe(System.out::println);
    }

    @Test
    void testMonoByMap() {
        Mono<Person> personMono = repo.getById(1);
        personMono
                .map(Person::getFirstName)
                .subscribe(System.out::println);
    }

    @Test
    void testFluxGetAllBlock() {
        Flux<Person> personMono = repo.getAll();
        Person person = personMono.blockFirst();
        assertNotNull(person);
        System.out.println(person);
    }

    @Test
    void testFluxByIDSubscribe() {
        Flux<Person> personMono = repo.getAll();
        personMono.subscribe(System.out::println);
    }

    @Test
    void testFLuxByMap() {
        Flux<Person> personFlux = repo.getAll();
        personFlux
                .map(Person::getFirstName)
                .subscribe(System.out::println);
    }

    @Test
    void testFLuxFilter() {
        Flux<Person> personFlux = repo.getAll();
        personFlux
                .filter(person -> person.getFirstName().startsWith("F"))
                .subscribe(System.out::println);
    }
}