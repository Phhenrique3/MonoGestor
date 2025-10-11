package com.example.MonoGestor.controller;

import com.example.MonoGestor.model.Funcionario;
import com.example.MonoGestor.service.FuncionarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios-html")
public class FuncionarioController {

    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Funcionario> listar() {
        return service.listarFuncionarios();
    }

    // Corrigido: removida a barra dentro das chaves
    @GetMapping("/{id}")
    public Funcionario buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario) {
        return service.create(funcionario);
    }

    // Corrigido: removida a barra dentro das chaves
    @PutMapping("/{id}")
    public Funcionario atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        return service.atualizar(id, funcionario);
    }

    // Corrigido: adicionado o path /{id} para deletar corretamente
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.delete(id); // supondo que você tenha um método deletar no service
    }
}
