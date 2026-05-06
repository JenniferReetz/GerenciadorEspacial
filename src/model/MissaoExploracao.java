package model;

import java.time.LocalDate;

public class MissaoExploracao extends Missao {
    private String tipoTerreno;
    private int duracaoDias;

    public MissaoExploracao(int id, String nome, String objetivo,
                            LocalDate dataLancamento, StatusMissao status,
                            String tipoTerreno, int duracaoDias) {
        super(id, nome, objetivo, dataLancamento, status);
        this.tipoTerreno = tipoTerreno;
        this.duracaoDias = duracaoDias;
    }

    // Construtor simplificado (compatível com seu código atual)
    public MissaoExploracao(int id, String nome, String objetivo,
                            LocalDate dataLancamento, StatusMissao status) {
        this(id, nome, objetivo, dataLancamento, status, "Desconhecido", 30);
    }

    @Override
    public String executar() {
        return "🔬 [EXPLORAÇÃO] Coletando dados científicos no terreno " +
                tipoTerreno + " na missão: " + getNome() +
                " (Duração: " + duracaoDias + " dias)";
    }

    public String getTipoTerreno() {
        return tipoTerreno;
    }

    public int getDuracaoDias() {
        return duracaoDias;
    }

}
