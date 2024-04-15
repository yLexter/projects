package testes;

import entidades.FuncionarioFilme;
import entidades.funcoes.*;
import interfaces.IFuncaoFilme;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FuncionarioFilmeTest {

    @Test
    public void testCriarFuncionario() {
        // Arrange
        String cpf = "123456789";
        String nome = "Funcionário Teste";
        List<IFuncaoFilme> funcoes = List.of(new Ator(), new Diretor());

        // Act
        FuncionarioFilme funcionario = new FuncionarioFilme(cpf, nome, funcoes);

        // Assert
        assertEquals(cpf, funcionario.getCpf());
        assertEquals(nome, funcionario.getNome());
        assertEquals(funcoes, funcionario.getFuncoes());
    }
}
