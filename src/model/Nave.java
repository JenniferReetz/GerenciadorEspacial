package model;

public class Nave {
    private int id;
    private String nome;
    private String tipo;
    private double capacidade;

    public Nave() {
    }

    public Nave(String nome, String tipo, double capacidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.capacidade = capacidade;
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

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCapacidade() {
        return this.capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public String toString() {
        return this.nome + " (" + this.tipo + ")";
    }
}
