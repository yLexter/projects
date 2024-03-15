package entities;

import utils.Global;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Funcionario {
    private List<String> turmasId;

    public Aluno(String nome, String sobrenome) {
        super(nome, sobrenome);
        this.turmasId = new ArrayList<>();
    }

    public void addDisciplina(String idTurma) {
        turmasId.add(idTurma);
    }

    public List<Turma> getTurmas() {
        ControleAcademico controleAcademico = Global.getControleAcademico();

        return controleAcademico.obterTurmasDeUmAluno(this);
    }

    public List<Horario> getHorario() {
        List<Horario> horarios = new ArrayList<>();

        for (Turma turma : getTurmas()) {
            horarios.addAll(turma.getHorarios());
        }

        return horarios;
    }

    public List<String> getTurmasId() {
        return turmasId;
    }
    
}
