package school.tests;

import org.junit.jupiter.api.*;
import school.entities.*;
import school.erros.FachadaControleAcademicoException;

import static org.junit.jupiter.api.Assertions.*;

public class FacadeTest {

    private FachadaControleAcademico fachada;
    private Professor professor;
    private Aluno aluno;
    private Disciplina disciplina;
    private Turma turma;
    private Sala sala;

    private AlunoTurma alunoTurmaHistorico;

    @BeforeEach
    public void setUp() {
        this.fachada = new FachadaControleAcademico();

        this.disciplina = fachada.adicionarDisciplina("MAT123", "Matemática", 1);
        this.professor = fachada.adicionarProfessor("João", "Silva", "123456789");
        this.aluno = fachada.adicionaAluno("Pedro", "Santos", "111222333");
        this.alunoTurmaHistorico = new AlunoTurma(aluno.getMatricula(), 14, 10, 10);

        fachada.adicionarCadeiraNoHistoricoAluno(
                aluno.getMatricula(),
                alunoTurmaHistorico,
                disciplina
        );

        this.turma = fachada.adicionarTurma(disciplina);

        fachada.adicionarAlunoEmTurma(turma.getId(), aluno.getMatricula());
        fachada.adicionarTurmaAProfessor(professor.getMatricula(), turma.getId());

        this.sala = fachada.adicionarSala("LAB V", 50);

        fachada.adicionarHorarioEmTurma(
                turma.getId(),
                "2M3M",
                sala.getNome()
        );
    }

    @Test
    public void testAdicionarDisciplina() {
        assertEquals(1, fachada.disciplinas.size());

        assertThrows(IllegalArgumentException.class, () -> {
            fachada.adicionarDisciplina("MAT123", "Matemática", 1);
        });
    }

    @Test
    public void testAdicionarProfessor() {
        assertEquals(1, fachada.professores.size());

        assertThrows(IllegalArgumentException.class, () -> {
            fachada.adicionarProfessor("João", "Silva", "123456789");
        });
    }

    @Test
    public void testAdicionaAluno() {
        assertEquals(1, fachada.alunos.size());

        assertThrows(IllegalArgumentException.class, () -> {
            fachada.adicionaAluno("Pedro", "Santos", "111222333");
        });
    }

    @Test
    public void testAdicionarSala() {
        assertEquals(1, fachada.salas.size());

        assertThrows(IllegalArgumentException.class, () -> {
            fachada.adicionarSala("LAB V", 50);
        });
    }

    @Test
    public void testAdicionarHorarioEmTurma() {
        assertEquals(1, turma.getHorarios().size());

        assertThrows(FachadaControleAcademicoException.class, () -> {
            fachada.adicionarHorarioEmTurma(turma.getId(), "2M3M", "LAB V");
        });

    }

    @Test
    public void testAdicionarTurmaAProfessor() {
        assertThrows(FachadaControleAcademicoException.class, () -> {
            fachada.adicionarTurmaAProfessor(professor.getMatricula(), turma.getId());
        });
    }

    @Test
    public void testAdicionarCadeiraNoHistoricoAluno() {
        assertEquals(1, aluno.getHistorico().size());

        assertThrows(FachadaControleAcademicoException.class, () -> {
            fachada.adicionarCadeiraNoHistoricoAluno(
                    aluno.getMatricula(),
                    alunoTurmaHistorico,
                    disciplina
            );
        });
    }

    @Test
    public void testAdicionarAlunoEmTurma() {
        assertTrue(aluno.getTurmasId().contains(turma.getId()));

        // Tentar adicionar o mesmo aluno à mesma turma deve lançar exceção
        assertThrows(IllegalArgumentException.class, () -> {
            fachada.adicionarAlunoEmTurma(turma.getId(), aluno.getMatricula());
        });
    }

    @Test
    public void testObterProfessorPorMatricula() {
        assertEquals(professor, fachada.obterProfessorPorMatricula(professor.getMatricula()));

        // Verifique se a exceção é lançada para um professor inexistente
        assertThrows(FachadaControleAcademicoException.class, () -> {
            fachada.obterProfessorPorMatricula("999999999");
        });
    }

    @Test
    public void testObterTurmaPorId() {
        assertEquals(turma, fachada.obterTurmaPorId(turma.getId()));

        // Verifique se a exceção é lançada para uma turma inexistente
        assertThrows(FachadaControleAcademicoException.class, () -> {
            fachada.obterTurmaPorId("999999999");
        });
    }

    @Test
    public void testObterAlunoPorId() {
        assertEquals(aluno, fachada.obterAlunoPorId(aluno.getMatricula()));

        // Verifique se a exceção é lançada para um aluno inexistente
        assertThrows(FachadaControleAcademicoException.class, () -> {
            fachada.obterAlunoPorId("999999999");
        });
    }
}
