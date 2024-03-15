package utils;

import entities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Examples {

    public static Map<String, List<?>> getAll() {
        Map<String, List<?>> mapa = new HashMap<>();
        List<Aluno> alunos = new ArrayList<>();
        List<Professor> professores = new ArrayList<>();
        List<Turma> turmas = new ArrayList<>();

        // Alunos
        alunos.add(new Aluno("João", "Silva"));
        alunos.add(new Aluno("Maria", "Santos"));
        
        // Turmas
        Turma t1 = new Turma("CPT01093", "PARADIGMAS DE PROGRAMAÇÃO", 60);

        t1.adicionarHorario(new Horario("2W12", t1.getId()));
        t1.adicionarHorario(new Horario("3D45", t1.getId()));

        for(Aluno aluno : alunos) {
            t1.adicionarAluno(aluno);
        }

        Turma t2 = new Turma("CPT01092", "ENGENHARIA DE SOFTWARE I", 60);

        t2.adicionarHorario(new Horario("1F45", t1.getId()));
        t2.adicionarHorario(new Horario("5N45", t1.getId()));

        for(Aluno aluno : alunos.subList(0,1)) {
            t2.adicionarAluno(aluno);
        }

        turmas.add(t1);
        turmas.add(t2);
        

        //Professores
        Professor p1 = new Professor("Carlos", "Silveira");
        Professor p2 = new Professor("Renata", "Lima");

        p1.addTurma(turmas.get(0));
        p1.addTurma(turmas.get(1));

        professores.add(p1);
        professores.add(p2);

        //Map
        mapa.put("professores", professores);
        mapa.put("alunos", alunos);
        mapa.put("turmas", turmas);

        return mapa;
    }

}
