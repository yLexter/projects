package utils;

import entities.*;

import java.util.ArrayList;
import java.util.List;

public class Examples {

    public static List<Aluno> alunos = new ArrayList<>();
    public static List<Professor> professores = new ArrayList<>();
    public static List<Turma> turmas = new ArrayList<>();


    public static List<Aluno> obterAlunos() {
        if (alunos.size() != 0)
            return alunos;

        alunos.add(new Aluno("João", "Silva"));
        alunos.add(new Aluno("Maria", "Santos"));

        return alunos;
    }

    public static List<Turma> obterTurmas() {
        if (turmas.size() != 0)
            return turmas;

        Turma t1 = new Turma("CPT01093", "PARADIGMAS DE PROGRAMAÇÃO", 60);

        t1.adicionarHorario(new Horario("2W12", t1.getId()));
        t1.adicionarHorario(new Horario("3D45", t1.getId()));

        for(Aluno aluno : obterAlunos()) {
            t1.adicionarAluno(aluno);
        }

        Turma t2 = new Turma("CPT01092", "ENGENHARIA DE SOFTWARE I", 60);

        t2.adicionarHorario(new Horario("1F45", t1.getId()));
        t2.adicionarHorario(new Horario("5N45", t1.getId()));

        for(Aluno aluno : obterAlunos().subList(0,1)) {
            t2.adicionarAluno(aluno);
        }

        turmas.add(t1);
        turmas.add(t2);

        return turmas;
    }


    public static List<Professor> obterProfessores() {
        if (professores.size() != 0)
            return professores;

        Professor p1 = new Professor("Carlos", "Silveira");
        Professor p2 = new Professor("Renata", "Lima");

        p1.addTurma(obterTurmas().get(0));
        p1.addTurma(obterTurmas().get(1));

        professores.add(p1);
        professores.add(p2);

        return professores;
    }

}
