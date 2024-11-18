package org.iesch.ad.exampleBBDD.model.Uni_OneToMany;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;

    @OneToMany
    @JoinColumn(name = "person_id")
    private List<Direccion> direcciones;
}
