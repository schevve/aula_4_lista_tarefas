package com.aula_4.cadastro_alunos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aula_4.cadastro_alunos.model.Aluno;
import com.aula_4.cadastro_alunos.service.AlunoService;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alunos", alunoService.listarAlunos());
        return "alunos/alunos";
    }

    @GetMapping("/cadastro")
    public String paginaCadastro() {
        return "alunos/cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarAluno(
            @RequestParam String nome,
            @RequestParam String matricula,
            @RequestParam String curso,
            @RequestParam int semestre) {
        alunoService.adicionarAluno(nome, semestre, curso, matricula, semestre);
        return "redirect:/alunos";
    }

    @GetMapping("/editar/{id}")
    public String paginaEditar(@PathVariable int id, Model model) {
        Aluno aluno = alunoService.buscarAlunoPorId(id);
        if (aluno == null) {
            return "redirect:/alunos";
        }
        model.addAttribute("aluno", aluno);
        return "alunos/editar";
    }

    @PostMapping("/editar/{id}")
    public String editarAluno(
            @PathVariable int id,
            @RequestParam String nome,
            @RequestParam String matricula,
            @RequestParam String curso,
            @RequestParam int semestre) {
        alunoService.atualizarAluno(id, nome, semestre, curso, matricula, semestre);
        return "redirect:/alunos";
    }

    @PostMapping("/excluir/{id}")
    public String excluirAluno(@PathVariable int id) {
        alunoService.removerAluno(id);
        return "redirect:/alunos";
    }
}
