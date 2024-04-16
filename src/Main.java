import entidades.Filme;
import entidades.FuncionarioFilme;
import entidades.GloboPlay;
import entidades.funcoes.Ator;
import entidades.funcoes.Diretor;
import entidades.funcoes.Roterista;
import interfaces.IFuncaoFilme;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Criando um objeto GloboPlay
        GloboPlay globoPlay = new GloboPlay();

        // Criando um filme
        List<String> trilhasSonoras = new ArrayList<>();
        trilhasSonoras.add("Trilha Sonora 1");
        Filme filme = new Filme("Filme 1", 2023, trilhasSonoras);

        // Cadastrando funcionários no filme
        List<IFuncaoFilme> funcoesFuncionario1 = new ArrayList<>();
        funcoesFuncionario1.add(new Ator());
        funcoesFuncionario1.add(new Diretor());
        FuncionarioFilme funcionario1 = new FuncionarioFilme("123456789", "Funcionario 1", funcoesFuncionario1);
        filme.cadastrarFuncionario("123456789", "Funcionario 1", funcoesFuncionario1);

        // Mostrando as funções do funcionário 1
        System.out.println("=== Funções do Funcionário 1 ===");
        mostrarFuncoesFuncionario(funcionario1);

        // Criando outro funcionário com múltiplas funções
        List<IFuncaoFilme> funcoesFuncionario2 = new ArrayList<>();
        funcoesFuncionario2.add(new Ator());
        funcoesFuncionario2.add(new Roterista());
        FuncionarioFilme funcionario2 = new FuncionarioFilme("987654321", "Funcionario 2", funcoesFuncionario2);

        // Mostrando as funções do funcionário 2
        System.out.println("\n=== Funções do Funcionário 2 ===");
        mostrarFuncoesFuncionario(funcionario2);
    }

    // Método para mostrar as funções de um funcionário
    private static void mostrarFuncoesFuncionario(FuncionarioFilme funcionario) {
        System.out.println("CPF: " + funcionario.getCpf());
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Funções:");
        for (IFuncaoFilme funcao : funcionario.getFuncoes()) {
            System.out.println("- " + funcao);
        }
    }
}
