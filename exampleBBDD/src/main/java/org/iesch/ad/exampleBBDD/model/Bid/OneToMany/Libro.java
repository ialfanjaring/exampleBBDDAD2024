package org.iesch.ad.exampleBBDD.model.Bid.OneToMany;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;

    @ManyToOne
    @JoinColumn (name = "autor")
    private Autor autor;
}
