package org.javaee8.validation;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@EqualsAndHashCode
@Entity
public class Person {

    @Id
    Long id;

    LocalDate from;

    @ManyToMany(mappedBy = Base_.PERSON)
    Base base;

    public Person() {
        System.out.println("DEFAULT CONSTRUCTOR");
        System.out.println("Person.Person");
    }

    public void setFrom(@NotNull LocalDate from) {
        System.out.println("Person.setFrom");
        System.out.println("from = [" + from + "]");
        this.from = from;
    }

    public Person(@NotNull final LocalDate from) {
        System.out.println("PARAMS CONSTRUCTOR");
        System.out.println("Person.Person");
        System.out.println("from = [" + from + "]");
        this.from = from;
    }
}