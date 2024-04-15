package entidades;

import entidades.Filme;
import entidades.FuncionarioFilme;
import entidades.funcoes.Ator;
import entidades.funcoes.Diretor;
import interfaces.IFuncaoFilme;
import entidades.funcoes.Roterista;
import java.util.ArrayList;
import java.util.List;

public class Creator {

    public static Filme criarFilme(String titulo, int anoLancamento, List<String> trilhasSonoras) {
        return new Filme(titulo, anoLancamento, trilhasSonoras);
    }

    public static FuncionarioFilme criarFuncionario(String cpf, String nome, List<String> funcoes) {
        List<IFuncaoFilme> funcoesFilme = new ArrayList<>();
        for (String funcao : funcoes) {
            switch (funcao) {
                case "Ator":
                    funcoesFilme.add(new Ator());
                    break;
                case "Diretor":
                    funcoesFilme.add(new Diretor());
                    break;
                case "Roterista":
                    funcoesFilme.add(new Roterista());
                    break;
                // Adicione outros tipos de funções aqui, se necessário
            }
        }
        return new FuncionarioFilme(cpf, nome, funcoesFilme);
    }
}
