package com.example.MonoGestor.service;

import com.example.MonoGestor.exception.ResourceNotFoundException;
import com.example.MonoGestor.model.Departamento;
import com.example.MonoGestor.model.Funcionario;
import com.example.MonoGestor.repository.DepartamentoRepository;
import com.example.MonoGestor.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repo;
    private final DepartamentoRepository depRepo;

    public FuncionarioService(FuncionarioRepository repo, DepartamentoRepository depRepo) {
        this.repo = repo;
        this.depRepo = depRepo;
    }

    public List<Funcionario> listarFuncionarios() {
        return repo.findAll();
    }

    public Funcionario buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário com ID " + id + " não encontrado"));
    }

    public Funcionario create(Funcionario dto) {
        // Busca o departamento correto
        Departamento d = depRepo.findById(dto.getDepartamento().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Departamento não encontrado"));

        Funcionario f = Funcionario.builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .email(dto.getEmail())
                .dataAdmissao(dto.getDataAdmissao())
                .departamento(d) // ⚡ agora é "departamento"
                .build();

        return repo.save(f);
    }

    public Funcionario atualizar(Long id, Funcionario dto) {
        Funcionario f = buscarPorId(id);

        Departamento departamento = depRepo.findById(dto.getDepartamento().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Departamento não encontrado"));

        f.setNome(dto.getNome());
        f.setCpf(dto.getCpf());
        f.setEmail(dto.getEmail());
        f.setDataAdmissao(dto.getDataAdmissao());
        f.setDepartamento(departamento); // ⚡ agora é "departamento"

        return repo.save(f);
    }

    public void delete(Long id) {
        Funcionario f = buscarPorId(id);
        repo.delete(f);
    }
}
