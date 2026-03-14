package com.aula_4.cadastro_alunos.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.aula_4.cadastro_alunos.model.Aluno;

@Repository
public class AlunoRepository {
    private List<Aluno> alunos = new ArrayList<Aluno>();

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void atualizarAluno(Aluno aluno) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getId() == aluno.getId()) {
                alunos.set(i, aluno);
                return;
            }
        }
    }

    public List<Aluno> getAllAlunos() {
        return alunos;
    }

    public Aluno getAlunoById(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                return aluno;
            }
        }
        return null; 
    }

    public void removerAluno(int id) {
        alunos.removeIf(aluno -> aluno.getId() == id);
    }
}
