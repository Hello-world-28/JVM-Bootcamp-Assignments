package com.ttn.SpringJpa3.model.manytomany;

import com.ttn.SpringJpa3.model.onetoone.AuthorOneToOne;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class BookManyToMany {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Long id;

    private String bookName;


    @ManyToMany(mappedBy = "books")
    private List<AuthorManyTOMany> authors;
}
