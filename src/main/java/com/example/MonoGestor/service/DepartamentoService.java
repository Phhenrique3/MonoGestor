package com.example.MonoGestor.service;

import com.example.MonoGestor.dto.DepartamentoDto;
import com.example.MonoGestor.exception.ResourceNotFoundException;
import com.example.MonoGestor.model.Departamento;
import com.example.MonoGestor.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    // 🔹 Buscar todos os departamentos
    public List<Departamento> buscarTodos() {
        return departamentoRepository.findAll();
    }

    // 🔹 Buscar departamento por ID
    public Departamento buscarPorId(Long id) {
        return departamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Departamento com ID " + id + " não encontrado"));
    }

    // 🔹 Criar novo departamento
    public Departamento criar(DepartamentoDto dto) {
        Departamento departamento = Departamento.builder()
                .nome(dto.getNome())
                .localizacao(dto.getLocalizacao())
                .build();
        return departamentoRepository.save(departamento);
    }

    // 🔹 Atualizar departamento existente
    public Departamento atualizar(Long id, DepartamentoDto dto) {
        Departamento departamento = buscarPorId(id);
        departamento.setNome(dto.getNome());
        departamento.setLocalizacao(dto.getLocalizacao());
        return departamentoRepository.save(departamento);
    }

    // 🔹 Deletar departamento
    public void deletar(Long id) {
        if (!departamentoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Departamento com ID " + id + " não encontrado");
        }
        departamentoRepository.deleteById(id);
    }
}
