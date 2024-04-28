package school.entities;

import java.util.UUID;

public class HistorcoAluno {

    private Disciplina disciplina;

    private AlunoTurma alunoTurma;

    private final String id;

    public HistorcoAluno(Disciplina disciplina, AlunoTurma alunoTurma) {
        this.disciplina = disciplina;
        this.alunoTurma = alunoTurma;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public AlunoTurma getAlunoTurma() {
        return alunoTurma;
    }

    @Override
    public String toString() {
        return "%s | %s".formatted(
                disciplina,
                alunoTurma
        );
    }
}