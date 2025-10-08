package com.example.MonoGestor.service;

import com.example.MonoGestor.dto.DepartamentoDto;
import com.example.MonoGestor.exception.ResourceNotFoundException;
import com.example.MonoGestor.model.Departamento;
import com.example.MonoGestor.model.Funcionario;
import com.example.MonoGestor.repository.DepartamentoRepository;
import com.example.MonoGestor.repository.FuncionarioRepository;

import java.util.List;

public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository, FuncionarioRepository funcionarioRepository) {

        this.departamentoRepository = departamentoRepository;
    }


    public List<Departamento> buscarTodos() {
        return departamentoRepository.findAll();
    }

    public Departamento buscarPorId(Long id) {
        return departamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Departamento com ID " + id + " não encontrado"));

    }


    public Departamento create(DepartamentoDto dto) {
        Departamento d = Departamento.builder()
                .nome(dto.getNome())
                .localizacao(dto.getLocalizacao())
                .build();

        return departamentoRepository.save(d);
    }
}






