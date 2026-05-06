package model;

import java.time.LocalDate;

public class MissaoResgate extends Missao {
    private final int numeroPessoasResgatar;
    private final boolean emergencia;

    public MissaoResgate(int id, String nome, String objetivo,
                         LocalDate dataLancamento, StatusMissao status,
                         int numeroPessoasResgatar, boolean emergencia) {
        super(id, nome, objetivo, dataLancamento, status);
        this.numeroPessoasResgatar = numeroPessoasResgatar;
        this.emergencia = emergencia;
    }

    public MissaoResgate(int id, String nome, String objetivo,
                         LocalDate dataLancamento, StatusMissao status) {
        this(id, nome, objetivo, dataLancamento, status, 0, false);
    }

    @Override
    public String executar() {
        String nivel = emergencia ? "URGENTE" : " NORMAL";
        return nivel + " [RESGATE] Resgatando " + numeroPessoasResgatar +
                " pessoa(s) na missão: " + getNome();
    }
    @Override
    public String getTipo() {
        return "Resgate";
    }
    public int getNumeroPessoasResgatar() {
        return numeroPessoasResgatar;
    }

    public boolean isEmergencia() {
        return emergencia;
    }
}
