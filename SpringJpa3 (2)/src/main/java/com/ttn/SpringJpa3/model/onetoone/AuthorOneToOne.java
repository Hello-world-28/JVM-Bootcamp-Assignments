package com.ttn.SpringJpa3.model.onetoone;


import com.ttn.SpringJpa3.model.Address;
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
public class AuthorOneToOne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String name;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "books_id")
    private BookOneToOne bookOneToOne;
}
