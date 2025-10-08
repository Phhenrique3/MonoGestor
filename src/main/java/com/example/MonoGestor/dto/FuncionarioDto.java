package com.example.MonoGestor.dto;


import com.example.MonoGestor.model.Departamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDto {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private Departamento departamento;
    private LocalDate dataAdmissao;

    private long departamentoId;
}
