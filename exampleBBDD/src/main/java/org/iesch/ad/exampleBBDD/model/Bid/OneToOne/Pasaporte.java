package org.iesch.ad.exampleBBDD.model.Bid.OneToOne;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Pasaporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String numero;

    @OneToOne
    @JoinColumn(name = "ciudadano_id")
    private Ciudadano ciudadano;
}
