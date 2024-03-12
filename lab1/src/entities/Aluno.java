package entities;

import utils.Global;

import java.util.ArrayList;
import java.util.List;
public class Aluno extends Funcionario {
    private List<String> turmas;

    public Aluno(String nome, String sobrenome) {
        super(nome, sobrenome);
        this.turmas = new ArrayList<>();
    }

    public void addDisciplina(String idTurma) {
        turmas.add(idTurma);
    }

    public List<Turma> getTurmas() {
        ControleAcademico controleAcademico = Global.getControleAcademico();

        return controleAcademico.obterTurmasDeUmAluno(turmas);
    }

    public List<Horario> obterHorario() {
        List<Horario> horarios = new ArrayList<>();

        for (Turma turma : getTurmas()) {
            horarios.addAll(turma.getHorarios());
        }

        return horarios;
    }


}