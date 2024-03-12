package entities;

import java.util.UUID;

public abstract class Funcionario {
    protected String nome;

    protected String sobrenome;

    protected String matricula;

    public Funcionario(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = UUID.randomUUID().toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "%s %s (%s)".formatted(nome, sobrenome, matricula);
    }

}
