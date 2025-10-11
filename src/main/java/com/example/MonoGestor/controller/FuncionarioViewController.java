package com.example.MonoGestor.controller;

import com.example.MonoGestor.model.Departamento;
import com.example.MonoGestor.model.Funcionario;
import com.example.MonoGestor.repository.DepartamentoRepository;
import com.example.MonoGestor.repository.FuncionarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioViewController {

    private final FuncionarioRepository funcionarioRepository;
    private final DepartamentoRepository departamentoRepository;

    public FuncionarioViewController(FuncionarioRepository funcionarioRepository,
                                     DepartamentoRepository departamentoRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.departamentoRepository = departamentoRepository;
    }

    // Listar funcionários e formulário para adicionar
    @GetMapping
    public String listarFuncionarios(Model model) {
        model.addAttribute("funcionarios", funcionarioRepository.findAll());
        model.addAttribute("departamentos", departamentoRepository.findAll());
        model.addAttribute("novoFuncionario", new Funcionario());
        return "funcionarios";
    }

    // Criar novo funcionário
    @PostMapping("/add")
    public String criarFuncionario(@ModelAttribute Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
        return "redirect:/funcionarios";
    }

    // Editar funcionário - mostra formulário preenchido
    @GetMapping("/edit/{id}")
    public String editarFuncionario(@PathVariable Long id, Model model) {
        Funcionario f = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        // Garante que departamento não seja null
        if (f.getDepartamento() == null) {
            f.setDepartamento(new Departamento());
        }

        model.addAttribute("funcionarioAtual", f);
        model.addAttribute("departamentos", departamentoRepository.findAll());
        model.addAttribute("novoFuncionario", new Funcionario()); // para o form de adicionar
        model.addAttribute("funcionarios", funcionarioRepository.findAll());
        return "funcionarios";
    }

    // Atualizar funcionário
    @PostMapping("/update/{id}")
    public String atualizarFuncionario(@PathVariable Long id, @ModelAttribute Funcionario funcionario) {
        Funcionario f = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
        f.setNome(funcionario.getNome());
        f.setCpf(funcionario.getCpf());
        f.setEmail(funcionario.getEmail());
        f.setDataAdmissao(funcionario.getDataAdmissao());
        f.setDepartamento(funcionario.getDepartamento());
        funcionarioRepository.save(f);
        return "redirect:/funcionarios";
    }

    // Deletar funcionário
    @GetMapping("/delete/{id}")
    public String deletarFuncionario(@PathVariable Long id) {
        funcionarioRepository.deleteById(id);
        return "redirect:/funcionarios";
    }
}
