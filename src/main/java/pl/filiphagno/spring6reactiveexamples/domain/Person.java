package pl.filiphagno.spring6reactiveexamples.domain;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    Integer id;
    private String firstName;
    private String lastName;
}
