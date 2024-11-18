package org.iesch.ad.exampleBBDD.model.Uni_ManyToOne;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;

    @ManyToMany
    @JoinTable(name = "estudiante_curso", joinColumns = @JoinColumn(name = "estudiante_id"), inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private List<Curso> cursos;
}
