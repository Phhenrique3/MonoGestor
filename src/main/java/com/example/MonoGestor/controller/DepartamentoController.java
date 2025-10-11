package com.example.MonoGestor.controller;

import com.example.MonoGestor.dto.DepartamentoDto;
import com.example.MonoGestor.model.Departamento;
import com.example.MonoGestor.service.DepartamentoService;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos-html")
public class DepartamentoController {

    private final DepartamentoService service;

    public DepartamentoController(DepartamentoService service) {
        this.service = service;
    }

    //  LISTAR todos os departamentos
    @GetMapping
    public List<Departamento> listar() {
        return service.buscarTodos();
    }

    // BUSCAR um departamento por ID
    @GetMapping("/{id}")
    public Departamento buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    //  CRIAR um novo departamento
    @PostMapping
    public Departamento criar(@RequestBody DepartamentoDto dto) {
        return service.criar(dto);
    }

    // 🟣 ATUALIZAR um departamento existente
    @PutMapping("/{id}")
    public Departamento atualizar(@PathVariable Long id, @RequestBody DepartamentoDto dto) {
        return service.atualizar(id, dto);
    }

    // 🔴 DELETAR um departamento
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
