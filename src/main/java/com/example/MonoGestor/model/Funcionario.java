package com.example.MonoGestor.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Funcionario")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long Id;

    private String nome;
    private String cpf;
    private String email;
    private String dataAdmissao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
}
