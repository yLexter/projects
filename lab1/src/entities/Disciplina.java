package entities;

public class Disciplina {
    protected String codigo;
    protected String nome;
    protected int horas;

    public Disciplina(String codigo, String nome, int horas) {
        this.codigo = codigo;
        this.nome = nome;
        this.horas = horas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

}
