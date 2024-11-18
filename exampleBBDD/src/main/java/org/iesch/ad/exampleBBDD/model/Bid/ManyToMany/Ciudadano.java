package org.iesch.ad.exampleBBDD.model.Bid.ManyToMany;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ciudadano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;

    @OneToOne
    private Pasaporte pasaporte;
}
