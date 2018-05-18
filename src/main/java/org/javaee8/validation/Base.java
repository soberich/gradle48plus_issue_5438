package org.javaee8.validation;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;


@Data
@MappedSuperclass
public class Base {
    @Id
    Long person;

    @ManyToMany
    Person user;
}
