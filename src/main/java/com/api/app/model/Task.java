package com.api.app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
    @Column(name = "estado_finalizacion")
    private boolean estadoFinalizacion;
}
