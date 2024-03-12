package menu;

import entities.*;
import interfaces.menu.*;
import utils.DataInput;
import utils.Global;

import java.util.List;

public class MenuSystem implements IMenu {

    @Override
    public List<IMenuOption> getOptions() {
        return List.of(
          new OptionMenu("Ver turmas/horarios de um professor", this::mostrarInformacaoDeUmProfessor),
          new OptionMenu("Ver turmas/horarios de uma aluno", this::mostrarInformacaoDeUmAluno),
          new OptionMenu("Ver alunos de uma disciplina", this::mostrarAlunosDeUmaDisciplina)
        );
    }

    public void mostrarInformacaoDeUmProfessor() {
        ControleAcademico controleAcademico = Global.getControleAcademico();
        List<Professor> professores = controleAcademico.getProfessores();

        Professor professor = DataInput.getElementFromListByUser(
             professores,
             Professor::toString,
             "Escolha um Professor"
        );

        List<Turma> turmas = professor.getTurmas();

        if (turmas.size() == 0) {
            System.out.println("Sem turmas no momento");
            return;
        }

        System.out.println();
        System.out.println("Turmas de um Professor\b");

        for (Turma turma : turmas) {
            System.out.printf("[%s] %s - (%s)\n",
                    turma.getCodigo(),
                    turma.getNome(),
                    turma.getId()
            );
        }

        System.out.println();
        System.out.println("Horários de um Professor\n");

        for (Turma turma : turmas) {

            for (Horario horario : turma.getHorarios()) {
                System.out.printf("Horario: %s - [%s]\n", horario, turma);
            }

        }


    }

    public void mostrarAlunosDeUmaDisciplina() {
        ControleAcademico controleAcademico = Global.getControleAcademico();
        List<Turma> turmas = controleAcademico.getTurmas();

        Turma turma = DataInput.getElementFromListByUser(
                turmas,
                Turma::toString,
                "Escolha um Turma"
        );

        if (turma.getTotalDeAluno() == 0) {
            System.out.println("Sem alunos no momento");
            return;
        }

        for(Aluno aluno : turma.getAlunos()) {
            System.out.printf("Aluno: %s\n", aluno);
        }

        System.out.println();
        System.out.printf("Total de Alunos: %d\n", turma.getTotalDeAluno());
    }

    public void mostrarInformacaoDeUmAluno() {
        ControleAcademico controleAcademico = Global.getControleAcademico();
        List<Aluno> alunos = controleAcademico.getAlunos();

        Aluno aluno = DataInput.getElementFromListByUser(
                alunos,
                Aluno::toString,
                "Escolha um aluno"
        );

        List<Turma> turmas = aluno.getTurmas();

        if (turmas.size() == 0) {
            System.out.println("Sem turmas no momento");
            return;
        }

        System.out.println();
        System.out.println("Turmas de um aluno\b");

        for (Turma turma : turmas) {
            System.out.printf("[%s] %s - (%s)\n",
                    turma.getCodigo(),
                    turma.getNome(),
                    turma.getId()
            );
        }

        System.out.println();
        System.out.println("Horários de um aluno\n\n");

        for (Horario horario : aluno.getHorario()) {
            System.out.printf("Horario: %s\n", horario);
        }

        System.out.println();
    }


    @Override
    public String getHeader() {
        return "";
    }

    @Override
    public void run() {
        new MenuExecutor(this).run();
    }



}