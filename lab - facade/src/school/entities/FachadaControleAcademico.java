package school.entities;

import school.erros.FachadaControleAcademicoException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FachadaControleAcademico {

    public final List<Aluno> alunos;
    public final List<Professor> professores;
    public final List<Turma> turmas;
    public final List<Disciplina> disciplinas;
    public final List<Sala> salas;

    public FachadaControleAcademico() {
        this.alunos = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.turmas = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.salas = new ArrayList<>();
    }

    // - Getters
    public List<Turma> obterTurmasDeUmAluno(String alunoId) {
        var aluno = obterAlunoPorId(alunoId);
        List<String> turmasId = aluno.getTurmasId();

        return turmas.stream()
                .filter(
                        turma ->
                                turmasId.stream()
                                        .anyMatch(turmaId -> turma.getId().equals(turmaId)))
                .collect(Collectors.toList());
    }

    public Professor obterProfessorPorMatricula(String matricula) {
        return professores.stream()
                .filter(professor -> professor.getMatricula().equals(matricula))
                .findAny()
                .orElseThrow(() -> new FachadaControleAcademicoException("Professor inexistente"));
    }

    public Turma obterTurmaPorId(String id) {
        return turmas.stream()
                .filter(turma -> turma.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new FachadaControleAcademicoException("Turma inexistente"));
    }

    public Aluno obterAlunoPorId(String id) {
        return alunos.stream()
                .filter(aluno -> aluno.getMatricula().equals(id))
                .findAny()
                .orElseThrow(() -> new FachadaControleAcademicoException("Aluno inexistente"));
    }

    // -- Adicionar Instancias
    public void adicionarAlunoEmTurma(String turmaId, String alunoId) {
        var novoAluno = obterAlunoPorId(alunoId);
        var turma = obterTurmaPorId(turmaId);
        var alunosTurma = turma.getAlunos();

        for (AlunoTurma aluno : alunosTurma) {
            if (aluno.getMatricula().equals(novoAluno.getMatricula()))
                throw new IllegalArgumentException("Aluno já está na turma");
        }

        AlunoTurma alunoTurma = new AlunoTurma(
                novoAluno.getMatricula()
        );

        novoAluno.addTurma(turma.getId());
        alunosTurma.add(alunoTurma);
    }

    public HistorcoAluno adicionarCadeiraNoHistoricoAluno(String idAluno, AlunoTurma novaCadeira, Disciplina disciplina) {
        Aluno aluno = obterAlunoPorId(idAluno);
        var historico  = aluno.getHistorico();
        var historicoAluno = new HistorcoAluno(disciplina, novaCadeira);

        for (var cadeira : historico) {
            if (cadeira.getAlunoTurma().getId().equals(novaCadeira.getId())) {
                throw new FachadaControleAcademicoException("Cadeira já ta no historico");
            }
        }

        aluno.getHistorico().add(historicoAluno);

        return historicoAluno;
    }

    public Professor adicionarProfessor(String nome, String sobrenome, String cpf) {
        var novoProfessor = new Professor(nome, sobrenome, cpf);

        for (var professor : professores) {
            if (professor.getCpf().equals(novoProfessor.getCpf())) {
                throw new IllegalArgumentException("Professor já existe");
            }
        }

        professores.add(novoProfessor);

        return novoProfessor;
    }

    public void adicionarTurmaAProfessor(String idProfessor, String idTurma) {
        var professor = obterProfessorPorMatricula(idProfessor);
        var turma = obterTurmaPorId(idTurma);

        for (var turmaAtual : turmas) {

            if (
                turma.getIdProfessor() != null &&
                turmaAtual.getIdProfessor().equals(professor.getMatricula()) &&
                turmaAtual.getId().equals(idTurma)
            ) {
                throw new FachadaControleAcademicoException("Professor já está na turma");
            }

        }


        turma.setIdProfessor(professor.getMatricula());
    }

    public Aluno adicionaAluno(String nome, String sobrenome, String cpf) {
        var novoAluno = new Aluno(nome, sobrenome, cpf);

        for (var aluno : alunos) {

            if (aluno.getCpf().equals(novoAluno.getCpf())) {
                throw new IllegalArgumentException("Aluno já existe");
            }
        }

        alunos.add(novoAluno);

        return novoAluno;
    }

    public Turma adicionarTurma(Disciplina disciplina) {
        var turma = new Turma(disciplina);

        turmas.add(turma);

        return turma;
    }

    public Disciplina adicionarDisciplina(String codigo, String nome, int periodo) {
        Disciplina novaDisciplina = new Disciplina(codigo, nome, periodo);

        for (var disciplina : disciplinas) {
            if (disciplina.getCodigo().equals(novaDisciplina.getCodigo())) {
                throw new IllegalArgumentException("Disciplina já existe");
            }
        }

        disciplinas.add(novaDisciplina);

        return novaDisciplina;
    }

    public Horario adicionarHorarioEmTurma(String turmaId, String horarioTurma, String nomeSala) {
        var turma = obterTurmaPorId(turmaId);

        var novoHorario = new Horario(horarioTurma, turma.getId(), nomeSala);

        for (Turma turmaAtual : turmas) {

            for (Horario horario : turmaAtual.getHorarios()) {
                boolean horarioEmUso = horario.getHorario().equals(novoHorario.getHorario());
                boolean salaEmUso = horario.getSalaId().equals(novoHorario.getSalaId());

                if (horarioEmUso && salaEmUso) {
                    throw new FachadaControleAcademicoException("Horario em uso");
                }

            }

        }

        turma.getHorarios().add(novoHorario);

        return novoHorario;
    }

    public Sala adicionarSala(String nome, int capacidade) {
        Sala novaSala = new Sala(nome, capacidade);

        for (var sala : salas) {
            if (sala.getNome().equals(novaSala.getNome())) {
                throw new IllegalArgumentException("Sala já existe");
            }
        }

        salas.add(novaSala);

        return novaSala;
    }

    // Relatorios
    public void mostrarDadosControleAcademico() {

        System.out.println("-".repeat(20) + " Alunos " + "-".repeat(20));
        System.out.println();

        for (var aluno : alunos) {
            var turmas = obterTurmasDeUmAluno(aluno.getMatricula());

            System.out.println();
            System.out.println("---------------------------------");
            System.out.println(aluno);

            System.out.println();
            System.out.println("--------------- RDM ---------------");

            for (var turma : turmas) {
                System.out.println(turma);
            }

            System.out.println("---------------------------------");
            System.out.println();
            System.out.println();

            System.out.println("--------------- Historico ---------------");

            for (var cadeira : aluno.getHistorico()) {
                System.out.println(cadeira);
            }

            System.out.println("---------------------------------");
            System.out.println();
            System.out.println();
        }

        System.out.println();

        System.out.println("-".repeat(20) + " Professores " + "-".repeat(20));
        System.out.println();

        for (var professor : professores) {
            System.out.println(professor);
        }

        System.out.println();
        System.out.println("-".repeat(50));
        System.out.println();

        for (var turma : turmas) {
            var professor = obterProfessorPorMatricula(turma.getIdProfessor());

            System.out.println();
            System.out.println("------------------------- Turma -------------------------");
            System.out.println();
            System.out.println(turma.getDisciplina());

            System.out.printf("Professor: %s\n", professor);

            System.out.println();
            System.out.println("------------ Alunos --------------------");

            for (var aluno : turma.getAlunos()) {
                System.out.println(aluno);
            }

            System.out.println();
            System.out.println("--------------- Horario ----------------------");

            for (var horario : turma.getHorarios()) {
                System.out.println(horario);
            }

            System.out.println("-------------------------------------------");
            System.out.println();
        }

    }
}
