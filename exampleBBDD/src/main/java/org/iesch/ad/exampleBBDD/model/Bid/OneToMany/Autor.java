package org.iesch.ad.exampleBBDD.model.Bid.OneToMany;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;

    @OneToMany
    private List<Libro> libros;
}
