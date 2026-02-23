package com.ttn.SpringJpa3.model.onetomany;


import com.ttn.SpringJpa3.model.Address;
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
public class AuthorOneToMany {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String name;

    @Embedded
    private Address addressModel;
    @ElementCollection
    private List<String> subjects;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "books_ref_id" ,referencedColumnName = "books_id")
    private List<BookOneToOne> bookOneToOne2;
}
