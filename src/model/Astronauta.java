package model;

public class Astronauta {
    private int id;
    private String nome;
    private String especialidade;

    public Astronauta() {
    }

    public Astronauta(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String toString() {
        return this.nome + " (" + this.especialidade + ")";
    }
}
