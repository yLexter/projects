import entidades.Creator;
import entidades.Filme;
import entidades.FuncionarioFilme;
import entidades.GloboPlay;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando uma instância de GloboPlay
        GloboPlay globoPlay = new GloboPlay();

        // Criando uma lista de trilhas sonoras
        List<String> trilhasSonoras = new ArrayList<>();
        trilhasSonoras.add("Trilha Sonora 1");
        trilhasSonoras.add("Trilha Sonora 2");

        // Cadastrando filmes na GloboPlay
        globoPlay.cadastrarFilme("Filme 1", 2022, trilhasSonoras);
        globoPlay.cadastrarFilme("Filme 2", 2023, trilhasSonoras);

        // Criando funcionários e suas funções
        FuncionarioFilme ator1 = Creator.criarFuncionario("123456789", "Ator 1", List.of("Ator"));
        FuncionarioFilme diretor1 = Creator.criarFuncionario("987654321", "Diretor 1", List.of("Diretor", "Roteirista"));

        // Cadastrando funcionários nos filmes
        List<Filme> filmes = globoPlay.getFilmes();
        if (!filmes.isEmpty()) {
            filmes.get(0).cadastrarFuncionario(ator1.getCpf(), ator1.getNome(), ator1.getFuncoes());
            filmes.get(0).cadastrarFuncionario(diretor1.getCpf(), diretor1.getNome(), diretor1.getFuncoes());
        }

        // Exibindo os filmes e suas informações
        globoPlay.mostrarFilmes();
    }
}
