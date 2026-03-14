package com.aula_4.cadastro_alunos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aula_4.cadastro_alunos.model.Aluno;
import com.aula_4.cadastro_alunos.repository.AlunoRepository;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public void adicionarAluno(String nome, int idade, String curso, String matricula, int semestre) {
        int id = alunoRepository.getAllAlunos().size() + 1;
        Aluno aluno = new Aluno();
        aluno.setId(id);
        aluno.setNome(nome);
        aluno.setCurso(curso);
        aluno.setMatricula(matricula);
        aluno.setSemestre(semestre);
        alunoRepository.adicionarAluno(aluno);
    }

    public Aluno buscarAlunoPorId(int id) {
        return alunoRepository.getAlunoById(id);
    }

    public void atualizarAluno(int id, String nome, int idade, String curso, String matricula, int semestre) {
        Aluno aluno = alunoRepository.getAlunoById(id);
        if (aluno != null) {
            aluno.setNome(nome);
            aluno.setCurso(curso);
            aluno.setMatricula(matricula);
            aluno.setSemestre(semestre);
            alunoRepository.atualizarAluno(aluno);
        }
    }

    public void removerAluno(int id) {
        alunoRepository.removerAluno(id);
    }

    public List<Aluno> listarAlunos() {
        return alunoRepository.getAllAlunos();
    }
}
