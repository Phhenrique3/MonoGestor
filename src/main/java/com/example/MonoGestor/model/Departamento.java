package com.example.MonoGestor.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Departamento")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String localizacao;


}
