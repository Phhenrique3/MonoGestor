package com.example.MonoGestor.controller;

import com.example.MonoGestor.model.Departamento;
import com.example.MonoGestor.repository.DepartamentoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoViewController {

    private final DepartamentoRepository repository;

    public DepartamentoViewController(DepartamentoRepository repository) {
        this.repository = repository;
    }

    // 🔹 Listar todos os departamentos
    @GetMapping
    public String listarDepartamentos(Model model) {
        model.addAttribute("departamentos", repository.findAll());
        model.addAttribute("departamento", new Departamento()); // form vazio
        return "departamentos";
    }

    // 🔹 Criar ou atualizar departamento
    @PostMapping("/salvar")
    public String salvarDepartamento(@ModelAttribute Departamento departamento) {
        repository.save(departamento); // salva ou atualiza
        return "redirect:/departamentos";
    }

    // 🔹 Carregar departamento para edição
    @GetMapping("/editar/{id}")
    public String editarDepartamento(@PathVariable Long id, Model model) {
        Departamento dep = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("departamento", dep);
        model.addAttribute("departamentos", repository.findAll());
        return "departamentos";
    }

    // 🔹 Deletar departamento
    @PostMapping("/deletar/{id}")
    public String deletarDepartamento(@PathVariable Long id) {
        Departamento dep = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));

        if(dep.getFuncionarios() != null && !dep.getFuncionarios().isEmpty()) {
            throw new IllegalStateException("Não é possível deletar departamento com funcionários!");
        }

        repository.delete(dep);
        return "redirect:/departamentos";
    }
}
