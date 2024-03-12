package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControleAcademico {
    private List<Aluno> alunos;
    private List<Professor> professores;
    private List<Turma> turmas;

    public ControleAcademico() {
        this.alunos = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.turmas = new ArrayList<>();
    }

    public Professor obterProfessorPorMatricula(String matricula) {
        return professores
                .stream()
                .filter(professor -> professor.getMatricula().equals(matricula))
                .findAny()
                .orElse(null);
    }

    public List<Turma> obterTurmasDeUmAluno(Aluno aluno) {
        List<String> turmasId = aluno.getTurmasId();

        return turmas
                .stream()
                .filter(turma -> turmasId
                        .stream()
                        .anyMatch(turmaId -> turma.getId().equals(turmaId)))
                .collect(Collectors.toList());
    }

    public boolean verificarHorarioEmUso(Horario novoHorario) {

        for (Turma turma : turmas) {

            for (Horario horario : turma.getHorarios()) {
                if (novoHorario.equals(horario))
                    return true;
            }
        }

        return false;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

}
