package com.ttn.SpringJpa3.model;


import com.ttn.SpringJpa3.model.onetoone.BookOneToOne;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String name;

    @Embedded
    private Address addressModel;
    @ElementCollection
    private List<String> subjects;
}
