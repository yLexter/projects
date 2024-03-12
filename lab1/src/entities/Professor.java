package entities;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Funcionario {
    private List<Turma> turmas;

    public Professor(String nome, String sobrenome) {
        super(nome, sobrenome);
        this.turmas = new ArrayList<>();
    }

    public void addTurma(Turma novaTurma) {
        for (Turma turma : turmas) {

            if (turma.equals(novaTurma))
                throw new IllegalArgumentException("Professor já pertence a turma");

        }

        novaTurma.setIdProfessor(matricula);
        turmas.add(novaTurma);
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

}