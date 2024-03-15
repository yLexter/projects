package entities;

import utils.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Turma {
    private Disciplina disciplina;
    private String idProfessor;
    private List<AlunoTurma> alunos;
    private List<Horario> horarios;
    public final String id;

    public Turma(Disciplina disciplina) {
        this.disciplina = disciplina;
        this.id = UUID.randomUUID().toString();
        this.horarios = new ArrayList<>();
        this.alunos = new ArrayList<>();
    }

    public Turma(Disciplina disciplina, String idProfessor) {
        this.disciplina = disciplina;
        this.idProfessor = idProfessor;
        this.id = UUID.randomUUID().toString();
        this.horarios = new ArrayList<>();
        this.alunos = new ArrayList<>();
    }

    public void adicionarHorario(Horario novoHorario) {
        ControleAcademico controleAcademico = Global.getControleAcademico();

        if (controleAcademico.verificarHorarioEmUso(novoHorario))
            throw new IllegalArgumentException("Horário em uso");

        horarios.add(novoHorario);
    }

    public void adicionarAluno(Aluno novoAluno) {

    }

    // ---------- Getters e Setters

    public String getNome() {
        return disciplina.nome;
    }

    public int getTotalDeAluno() {
        return alunos.size();
    }

    public List<AlunoTurma> getAlunos() {
        return alunos;
    }

    public Professor getProfessor() {
        ControleAcademico controleAcademico = Global.getControleAcademico();

        return controleAcademico.obterProfessorPorMatricula(idProfessor);
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public String getIdProfessor() {
        return idProfessor;
    }

    public String getId() {
        return id;
    }

    public void setIdProfessor(String idProfessor) {
        this.idProfessor = idProfessor;
    }

    public void setAlunos(List<AlunoTurma> alunos) {
        this.alunos = alunos;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    @Override
    public String toString() {
        return "[%s] %s (%s)".formatted(disciplina.codigo, disciplina.nome, id);
    }

}
