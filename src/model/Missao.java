package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Missao {
    private int id;
    private String nome;
    private String objetivo;
    private LocalDate dataLancamento;
    private StatusMissao status;
    private Nave nave;
    private List<Astronauta> astronautas;

    public Missao() {
        this.astronautas = new ArrayList<>();
    }

    public Missao(int id, String nome, String objetivo, LocalDate dataLancamento, StatusMissao status) {
        this.id = id;
        this.nome = nome;
        this.objetivo = objetivo;
        this.dataLancamento = dataLancamento;
        this.status = status;
        this.astronautas = new ArrayList<>();
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

    public String getObjetivo() {
        return this.objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public LocalDate getDataLancamento() {
        return this.dataLancamento;
    }

    public void setDataLancamento(LocalDate data) {
        this.dataLancamento = data;
    }

    public String getTipo() {
        return "Padrão";
    }
    public StatusMissao getStatus() {
        return this.status;
    }

    public void setStatus(StatusMissao status) {
        this.status = status;
    }

    public Nave getNave() {
        return this.nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }

    public List<Astronauta> getAstronautas() {
        if (this.astronautas == null) {
            this.astronautas = new ArrayList();
        }

        return this.astronautas;
    }

    public void setAstronautas(List<Astronauta> astronautas) {
        this.astronautas = astronautas;
    }

    public String executar() {
        return "\ud83d\ude80 Executando missão padrão: " + this.nome;
    }

    public String toString() {
        String naveInfo = this.nave != null ? this.nave.getNome() : "N/A";
        int var10000 = this.id;
        return "Missão [ID: " + var10000 + ", Nome: " + this.nome + ", Status: " + String.valueOf(this.status) + ", Nave: " + naveInfo + "]";
    }
}
