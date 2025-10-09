package com.example.MonoGestor.service;

import com.example.MonoGestor.dto.DepartamentoDto;
import com.example.MonoGestor.exception.ResourceNotFoundException;
import com.example.MonoGestor.model.Departamento;
import com.example.MonoGestor.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // <- ESSENCIAL: registra o bean no Spring
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    // Aqui você não precisa do FuncionarioRepository se não vai usar
    public DepartamentoService(DepartamentoRepository departamentoRepository) {
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

    public Departamento Atualizar(Long id, DepartamentoDto dto) {
        Departamento d = buscarPorId(id);
        d.setNome(dto.getNome());
        d.setLocalizacao(dto.getLocalizacao());
        return departamentoRepository.save(d);
    }

    public void deletar(Long id) {
        departamentoRepository.deleteById(id);
    }
}
