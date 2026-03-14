package com.aula_4.cadastro_alunos.model;

public class Aluno {
    private int id;
    private String nome;
    private String matricula;
    private String curso;
    private int semestre;

    public Aluno() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public int getSemestre() {
        return semestre;
    }

}
