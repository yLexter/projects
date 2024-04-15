package testes;

import entidades.Creator;
import entidades.FuncionarioFilme;
import entidades.funcoes.Ator;
import entidades.funcoes.Diretor;
import entidades.funcoes.Roterista;
import interfaces.IFuncaoFilme;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import erros.GloboPlayException;


import java.util.List;

public class CreatorTest {

    @Test
    public void testCriarFuncionario() {
        // Arrange
        String cpf = "123456789";
        String nome = "Funcionario Teste";
        List<String> funcoes = List.of("Ator", "Diretor");

        // Act
        FuncionarioFilme funcionario = Creator.criarFuncionario(cpf, nome, funcoes);

        // Assert
        assertEquals(cpf, funcionario.getCpf());
        assertEquals(nome, funcionario.getNome());
        assertEquals(funcoes.size(), funcionario.getFuncoes().size());
    }

    @Test(expected = GloboPlayException.class)
    public void testCriarFuncionarioComFuncaoDesconhecida() {
        // Arrange
        String cpf = "123456789";
        String nome = "Funcionario Teste";
        List<String> funcoes = List.of("Ator", "Diretor", "FuncaoDesconhecida");

        // Act
        Creator.criarFuncionario(cpf, nome, funcoes);
    }
}