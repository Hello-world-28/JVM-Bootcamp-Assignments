package com.ttn.SpringJpa3.model.onetomany;

import com.ttn.SpringJpa3.model.onetoone.AuthorOneToOne;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class BookManyToOne {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Long id;

    private String bookName;


    //bidirectional
    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name="author_ref", referencedColumnName = "authorId")
    private AuthorOneToOne author;
}
