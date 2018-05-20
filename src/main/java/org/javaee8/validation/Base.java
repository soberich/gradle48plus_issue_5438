package org.javaee8.validation;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@MappedSuperclass
public class Base {
    @Id
    Long person;

    @ManyToMany
    Person user;

    List<@NotNull String> strings;
}
